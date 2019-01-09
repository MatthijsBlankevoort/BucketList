package com.example.matthijsblankevoort.bucketlist;

import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingActionButton;

    private List<BucketListItem> bucketListItems = new ArrayList<>();

    public static BucketListViewModel bucketListViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bucketListViewModel = new BucketListViewModel(getApplicationContext());



        BucketListDatabase db = BucketListDatabase.getBucketListDatabase(this);
        bucketListItems = new ArrayList<>();
//        bucketListItems = db.BucketListItemDao().getAllBucketListItems();

        mRecyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new BucketListAdapter(bucketListItems);
        mRecyclerView.setAdapter(mAdapter);

        bucketListViewModel.getBucketListItems().observe(this, new Observer<List<BucketListItem>>() {
            @Override
            public void onChanged(@Nullable List<BucketListItem> bucketListItemList) {
                bucketListItems.clear();
                bucketListItems.addAll(bucketListItemList);
                mAdapter.notifyDataSetChanged();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateBucketListItemActivity.class));
            }
        });
    }
}

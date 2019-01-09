package com.example.matthijsblankevoort.bucketlist;

import android.app.usage.NetworkStats;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateBucketListItemActivity extends AppCompatActivity {


    private FloatingActionButton saveButton;
    private EditText title;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bucket_list_item);

        title = findViewById(R.id.bucketlistitem_title);
        description = findViewById(R.id.description);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BucketListItem bucketListItem = new BucketListItem();

                bucketListItem.setTitle(title.getText().toString());
                bucketListItem.setDescription(description.getText().toString());
                bucketListItem.setCompleted(false);
                MainActivity.bucketListViewModel.insert(bucketListItem);
                finish();
            }
        });
    }
}

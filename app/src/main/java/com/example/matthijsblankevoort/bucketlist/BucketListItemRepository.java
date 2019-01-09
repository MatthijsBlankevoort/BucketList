package com.example.matthijsblankevoort.bucketlist;

import android.app.usage.NetworkStats;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BucketListItemRepository {
    private BucketListDatabase bucketListDatabase;
    private BucketListItemDAO bucketListItemDAO;
    private LiveData<List<BucketListItem>> bucketListItems;
    private Executor executor = Executors.newSingleThreadExecutor();

    public BucketListItemRepository (Context context) {
        bucketListDatabase = BucketListDatabase.getBucketListDatabase(context);
        bucketListItemDAO = bucketListDatabase.BucketListItemDao();
        bucketListItems = bucketListItemDAO.getAllBucketListItems();
    }

    public LiveData<List<BucketListItem>> getBucketListItems() {
        return bucketListItems;
    }

    public void insert(final BucketListItem bucketListItem) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bucketListItemDAO.insert(bucketListItem);
            }
        });
    }

    public void update(final BucketListItem bucketListItem) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bucketListItemDAO.update(bucketListItem);
            }
        });
    }

    public void delete(final BucketListItem bucketListItem) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                bucketListItemDAO.delete(bucketListItem);
            }
        });
    }
}

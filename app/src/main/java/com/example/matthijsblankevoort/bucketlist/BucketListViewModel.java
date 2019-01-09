package com.example.matthijsblankevoort.bucketlist;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

public class BucketListViewModel {
    private BucketListItemRepository bucketListItemRepository;
    private LiveData<List<BucketListItem>> bucketListItems;

    public BucketListViewModel(Context context) {
        bucketListItemRepository = new BucketListItemRepository(context);
        bucketListItems = bucketListItemRepository.getBucketListItems();
    }

    public LiveData<List<BucketListItem>> getBucketListItems() {
        return bucketListItems;
    }

    public void insert(BucketListItem bucketListItem) {
        bucketListItemRepository.insert(bucketListItem);
    }

    public void update(BucketListItem bucketListItem) {
        bucketListItemRepository.update(bucketListItem);
    }

    public void delete(BucketListItem bucketListItem) {
        bucketListItemRepository.delete(bucketListItem);
    }
}

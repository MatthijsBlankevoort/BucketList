package com.example.matthijsblankevoort.bucketlist;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BucketListItemDAO {
    @Query("SELECT * FROM bucketlistitem")
    public LiveData<List<BucketListItem>> getAllBucketListItems();

    @Insert
    void insert(BucketListItem bucketListItem);

    @Update
    void update(BucketListItem bucketListItem);

    @Delete
    void delete(BucketListItem user);
}

package com.example.matthijsblankevoort.bucketlist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BucketListItemDAO {
    @Query("SELECT * FROM bucketlistitem")
    List<BucketListItem> getAll();

    @Insert
    void insert(BucketListItem bucketListItem);

    @Delete
    void delete(BucketListItem user);
}

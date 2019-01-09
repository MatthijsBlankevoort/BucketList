package com.example.matthijsblankevoort.bucketlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.matthijsblankevoort.bucketlist.BucketListItem;
import com.example.matthijsblankevoort.bucketlist.BucketListItemDAO;

@Database(entities = {BucketListItem.class}, version = 1)
public abstract class BucketListDatabase extends RoomDatabase {

    private static BucketListDatabase INSTANCE;

    public abstract BucketListItemDAO BucketListItemDao();

    public static BucketListDatabase getBucketListDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), BucketListDatabase.class, "bucketlist-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
}
package com.example.matthijsblankevoort.bucketlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.MyViewHolder> {
    private List<BucketListItem> mBucketListItems;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public CheckBox checkBox;
        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.bucketlist_description);
            checkBox = v.findViewById(R.id.checkBox);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BucketListAdapter(List<BucketListItem> myDataset) {
        this.mBucketListItems = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bucketlist_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.
            textView.setText(mBucketListItems.get(position).getDescription());
        holder.checkBox.setText(mBucketListItems.get(position).getTitle());
        holder.checkBox.setChecked(mBucketListItems.get(position).getCompleted());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.checkBox.setChecked(true);
                mBucketListItems.get(position).setCompleted(!mBucketListItems.get(position).getCompleted());
                MainActivity.bucketListViewModel.update(mBucketListItems.get(position));
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.mBucketListItems.size();
    }
}


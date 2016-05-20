package com.epicodus.dreamwhale.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.models.Dream;
import com.epicodus.dreamwhale.util.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

public class FirebaseDreamListAdapter extends FirebaseRecyclerAdapter<DreamViewHolder, Dream> {

    public FirebaseDreamListAdapter(Query query, Class<Dream> itemClass) {
        super(query, itemClass);
    }

    @Override
    public DreamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dream_list_item, parent, false);
        return new DreamViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(DreamViewHolder holder, int position) {
        holder.bindDream(getItem(position));
    }

    @Override
    protected void itemAdded(Dream item, String key, int position) {

    }

    @Override
    protected void itemChanged(Dream oldItem, Dream newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Dream item, String key, int position) {

    }

    @Override
    protected void itemMoved(Dream item, String key, int oldPosition, int newPosition) {

    }
}
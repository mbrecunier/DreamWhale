package com.epicodus.dreamwhale.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.adapters.FirebaseDreamListAdapter;
import com.epicodus.dreamwhale.models.Dream;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PublicDreamsListActivity extends AppCompatActivity {
    private Query mQuery;
    private DatabaseReference mFirebaseDreamsRef;
    private FirebaseDreamListAdapter mAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_dreams_list);
        ButterKnife.bind(this);

        mFirebaseDreamsRef = FirebaseDatabase.getInstance().getReference().child("publicDreams");

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        mQuery = mFirebaseDreamsRef.child("publicDreams").orderByChild("dateInverse");
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseDreamListAdapter(mQuery, Dream.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}

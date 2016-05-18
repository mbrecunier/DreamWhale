package com.epicodus.dreamwhale.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.adapters.FirebaseDreamListAdapter;
import com.epicodus.dreamwhale.models.Dream;
import com.epicodus.dreamwhale.util.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PublicDreamsListActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseDreamsRef;
    private FirebaseDreamListAdapter mAdapter;
    private ArrayList<Dream> dreams = new ArrayList<>();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_dreams_list);
        ButterKnife.bind(this);

        mFirebaseDreamsRef = new Firebase(Constants.FIREBASE_PUBLIC_DREAMS_URL);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        String dream = mFirebaseDreamsRef.toString();
        mQuery = new Firebase(dream).orderByChild("dateInverse");
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseDreamListAdapter(mQuery, Dream.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}

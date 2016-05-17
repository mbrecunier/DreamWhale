package com.epicodus.dreamwhale.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.adapters.FirebaseDreamListAdapter;
import com.epicodus.dreamwhale.models.Dream;
import com.epicodus.dreamwhale.util.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedDreamsListActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseDreamsRef;
    private FirebaseDreamListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private ArrayList<Dream> dreams = new ArrayList<>();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_dreams_list);
        ButterKnife.bind(this);

        mFirebaseDreamsRef = new Firebase(Constants.FIREBASE_DREAMS_URL);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
        String dream = mFirebaseDreamsRef.child(userUid).toString();
//        Log.d("DREAM DATE: ", dream.orderByChild("date").toString());
        mQuery = new Firebase(dream);
        Log.d("DREAM: ", dream + "");

    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseDreamListAdapter(mQuery, Dream.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}

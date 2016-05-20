package com.epicodus.dreamwhale.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.adapters.FirebaseDreamListAdapter;
import com.epicodus.dreamwhale.models.Dream;
import com.epicodus.dreamwhale.util.Constants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedDreamsListActivity extends BaseActivity {
    private Query mQuery;
    private DatabaseReference mFirebaseDreamsRef;
    private FirebaseDreamListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_dreams_list);
        ButterKnife.bind(this);

        mFirebaseDreamsRef = FirebaseDatabase.getInstance().getReference().child("userDreams");
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
        mQuery = mFirebaseDreamsRef.child(userUid).orderByChild("dateInverse");
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseDreamListAdapter(mQuery, Dream.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}

package com.epicodus.dreamwhale.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.adapters.DreamPagerAdapter;
import com.epicodus.dreamwhale.models.Dream;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DreamDetailActivity extends AppCompatActivity {
    @Bind(R.id.dreamViewPager) ViewPager mViewPager;
    private DreamPagerAdapter adapterViewPager;
    ArrayList<Dream> mDreams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_detail);
        ButterKnife.bind(this);
        mDreams = Parcels.unwrap(getIntent().getParcelableExtra("dreams"));
        int startingPostition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new DreamPagerAdapter(getSupportFragmentManager(), mDreams);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPostition);
    }
}

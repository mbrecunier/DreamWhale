package com.epicodus.dreamwhale.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.dreamwhale.models.Dream;
import com.epicodus.dreamwhale.ui.DreamDetailFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Guest on 5/16/16.
 */
public class DreamPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Dream> mDreams;

    public DreamPagerAdapter(FragmentManager fm, ArrayList<Dream> dreams) {
        super(fm);
        mDreams = dreams;
    }

    @Override
    public Fragment getItem(int position) {
        return DreamDetailFragment.newInstance(mDreams.get(position));
    }

    @Override
    public int getCount() {
        return mDreams.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Dream thisDream = mDreams.get(position);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
        CharSequence humanDate = dateFormat.format(thisDream.getDate());
        return humanDate;
    }
}
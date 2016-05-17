package com.epicodus.dreamwhale.ui;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.adapters.FormPagerAdapter;
import com.epicodus.dreamwhale.util.ColorPickerListener;
import com.larswerkman.holocolorpicker.ColorPicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddDreamActivity extends BaseActivity implements ColorPickerListener {
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dream);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new FormPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

    }
}



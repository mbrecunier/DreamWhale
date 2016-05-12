package com.epicodus.dreamwhale.ui;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.adapters.FormPagerAdapter;
import com.larswerkman.holocolorpicker.ColorPicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddDreamActivity extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;
    private ColorPicker mColorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dream);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new FormPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

//        COLLECT FROM DATEPICKER

//        public void onDateSet(DatePicker view, int year, int month, int day) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(year, month, day);
//
//            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM");
//            String output = formatter.format(calendar.getTime()); //eg: "Tue May"
//        }


//          COLLECT FROM COLOR PICKER


//        COLLECT FROM DESCRIPTION

//        CREATE DREAM OBJ (in an on event click listener?
    }
}



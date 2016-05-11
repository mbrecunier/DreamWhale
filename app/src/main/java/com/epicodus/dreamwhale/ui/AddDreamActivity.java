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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dream);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new FormPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);



    }
}


// TODO: ADD THESE BUTTONS BACK INTO LAYOUT WHERE APPROPRIATE
//<Button
//android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:text="cancel"
//        android:id="@+id/cancelButton"
//        android:layout_alignParentBottom="true"
//        android:layout_alignParentLeft="true"
//        android:layout_alignParentStart="true"
//        android:drawableLeft="@drawable/ic_cloud_off_white_24dp"
//        android:drawablePadding="3dp"
//        android:width="120dp"
//        android:textColor="@color/colorTextIcons"
//        android:background="#de5d5d"
//        android:padding="8dp"
//        android:textStyle="bold"
//        android:textSize="17sp" />
//
//<Button
//android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:text="save"
//        android:id="@+id/saveButton"
//        android:layout_alignParentBottom="true"
//        android:layout_alignParentRight="true"
//        android:layout_alignParentEnd="true"
//        android:drawableLeft="@drawable/ic_cloud_done_white_24dp"
//        android:drawablePadding="3dp"
//        android:width="120dp"
//        android:textColor="@color/colorTextIcons"
//        android:background="@color/colorPrimaryDark"
//        android:padding="8dp"
//        android:textStyle="bold"
//        android:textSize="17sp" />

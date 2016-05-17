package com.epicodus.dreamwhale.ui;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.util.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DatePickerFragment extends BaseFragment {
    @Bind(R.id.datePicker) DatePicker mDatePicker;

    public DatePickerFragment(){}

    public static DatePickerFragment newInstance() {
        DatePickerFragment dateFragment = new DatePickerFragment();
        return dateFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_date_picker, container, false);
        ButterKnife.bind(this, view);


        mDatePicker.init(mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(i, i1, i2);
                Long date = calendar.getTimeInMillis();
                mSharedPreferencesEditor.putLong(Constants.DATE, date).apply();
                Log.d("date?: ", date.toString());
            }
        });
        return view;
    }
}

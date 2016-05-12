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
    private String title;
    private int page;
    @Bind(R.id.datePromptTextView) TextView mDatePromptTextView;
    @Bind(R.id.datePicker) DatePicker mDatePicker;

    public DatePickerFragment(){}

    public static DatePickerFragment newInstance(int page, String title) {
        DatePickerFragment dateFragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("Date", title);
        dateFragment.setArguments(args);

        return dateFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("Date");

//      TODO Need to get data from DatePicker w/o incorporating dialog
//        Date date = new Date();
//
//        date.g
//        getDateInstance()
//
//        mDatePicker.init(mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//                Calendar calendar = Calendar.getInstance();
//                calendar.set(i, i1, i2);
//                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
//                String pickedDate = dateFormat.format(calendar.getTime());
//                Log.d("Date", pickedDate);
//            }
//        });
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
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
                String pickedDate = dateFormat.format(calendar.getTime());
                mSharedPreferencesEditor.putString(Constants.DATE, pickedDate).apply();
                Log.d("date?: ", pickedDate);
            }
        });

        return view;
    }
}

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DatePickerFragment  extends Fragment {
    private String title;
    private int page;
    @Bind(R.id.datePromptTextView) TextView mDatePromptTextView;

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
        ButterKnife.bind(getActivity());
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("Date");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_date_picker, container, false);

        return view;
    }

    //onclick function
        //if they clicked on calendar
            //set date variable to date that user clicked

//        Date date = new Date();
//
//        DateFormat fmt = new SimpleDateFormat("yyyy");
//
//        String dateString = fmt.format(date);
////        String stringDate = date.toString();
//        Log.d("The date is: ", dateString);



}

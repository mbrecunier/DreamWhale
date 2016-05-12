package com.epicodus.dreamwhale.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.dreamwhale.R;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.SVBar;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ColorPickerFragment extends Fragment {
    private int page;
    private String title;
    @Bind(R.id.pickColorTextView) TextView mPickColorTextView;
    @Bind(R.id.colorPicker) ColorPicker mColorPicker;
    @Bind(R.id.svbar) SVBar mSVBar;
    private int color1;

    public ColorPickerFragment() {
    }

    public static ColorPickerFragment newInstance(int page, String title) {
        ColorPickerFragment colorFragment = new ColorPickerFragment();
        Bundle args = new Bundle();
        args.putInt("someOtherInt", page);
        args.putString("Color", title);
        colorFragment.setArguments(args);
        return colorFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someOtherInt", 3);
        title = getArguments().getString("Color");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_picker, container, false);
        ButterKnife.bind(this, view);

        mColorPicker.addSVBar(mSVBar);
        mColorPicker.setShowOldCenterColor(false);



        mColorPicker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                Log.d("color changed: ", Integer.toString(color));
            }
        });
//        color1 = mColorPicker.getColor();
//        Log.d("initial color = ", Integer.toString(color1));

        return view;
    }

}

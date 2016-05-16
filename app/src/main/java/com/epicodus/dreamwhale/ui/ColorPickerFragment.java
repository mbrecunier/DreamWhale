package com.epicodus.dreamwhale.ui;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.util.Constants;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ColorPickerFragment extends BaseFragment {
    private int page;
    private String title;
    @Bind(R.id.pickColorTextView) TextView mPickColorTextView;
    @Bind(R.id.colorPicker) ColorPicker mColorPicker;
    @Bind(R.id.opacitybar) OpacityBar mOpacityBar;
    @Bind(R.id.saturationbar) SaturationBar mSaturationBar;
    @Bind(R.id.valuebar) ValueBar mValueBar;

    private String mPickedColor;


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
        mColorPicker.addValueBar(mValueBar);
        mColorPicker.addSaturationBar(mSaturationBar);
        mColorPicker.addOpacityBar(mOpacityBar);
        mColorPicker.setShowOldCenterColor(false);

        mColorPicker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                String alpha =  String.format("%02x", Color.alpha(color)),
                        red = String.format("%02x", Color.red(color)),
                        green = String.format("%02x", Color.green(color)),
                        blue = String.format("%02x", Color.blue(color));

                mSharedPreferencesEditor.putString(Constants.COLORALPHA, alpha).apply();
                mSharedPreferencesEditor.putString(Constants.COLORRED, red).apply();
                mSharedPreferencesEditor.putString(Constants.COLORGREEN, green).apply();
                mSharedPreferencesEditor.putString(Constants.COLORBLUE, blue).apply();
                mPickedColor = mSharedPreferences.getString(Constants.COLORALPHA, null) + mSharedPreferences.getString(Constants.COLORRED, null) + mSharedPreferences.getString(Constants.COLORGREEN, null) +  mSharedPreferences.getString(Constants.COLORBLUE, null);
                mSharedPreferencesEditor.putString(Constants.COLOR, mPickedColor).apply();

                Log.d("Picked Color: ",  mPickedColor);

            }
        });
        return view;
    }

    public int getColorPickerColor() {
        return mColorPicker.getColor();
    }


//    Turns out lifecycle events don't trigger if all fragments belong to same parent activity.
//    @Override
//    public void onPause() {
//        //save color to shared preferences
//        super.onPause();
//        String endColor = Integer.toString(mColorPicker.getColor());
//        Log.d("onPause", endColor);
//    }
//
//    @Override
//    public void onDestroy() {
//        //save color to shared preferences
//        super.onDestroy();
//        String endColor = Integer.toString(mColorPicker.getColor());
//        Log.d("onDestroy", endColor);
//    }
//
//    @Override
//    public void onDetach() {
//        //save color to shared preferences
//        super.onDetach();
//        String endColor = Integer.toString(mColorPicker.getColor());
//        Log.d("onDetach", endColor);
//    }
}

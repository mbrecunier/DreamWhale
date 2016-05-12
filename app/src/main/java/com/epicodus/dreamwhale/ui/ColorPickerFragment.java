package com.epicodus.dreamwhale.ui;


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
import com.larswerkman.holocolorpicker.SVBar;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ColorPickerFragment extends BaseFragment {
    private int page;
    private String title;
    @Bind(R.id.pickColorTextView) TextView mPickColorTextView;
    @Bind(R.id.colorPicker) ColorPicker mColorPicker;
    @Bind(R.id.svbar) SVBar mSVBar;

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
                mSharedPreferencesEditor.putString(Constants.COLOR, Integer.toString(color)).apply();
//                Log.d("Color :", mSharedPreferences.getString(Constants.COLOR, null));
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

package com.epicodus.dreamwhale.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.dreamwhale.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorPickerFragment extends Fragment {
    private int page;
    private String title;
    @Bind(R.id.pickColorTextView) TextView mPickColorTextView;

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
        ButterKnife.bind(getActivity());
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someOtherInt", 3);
        title = getArguments().getString("Color");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_picker, container, false);

//        ColorPicker picker = (ColorPicker) findViewById(R.id.picker);
//        picker.getColor();
        // Inflate the layout for this fragment
        return view;
    }

}

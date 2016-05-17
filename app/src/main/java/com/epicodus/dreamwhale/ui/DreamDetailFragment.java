package com.epicodus.dreamwhale.ui;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.models.Dream;

import org.parceler.Parcels;

import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.ButterKnife;


public class DreamDetailFragment extends Fragment {
    @Bind(R.id.dreamDateTextView) TextView mDreamDateTextView;
    @Bind(R.id.dreamDescriptionTextView) TextView mDreamDescriptionTextView;
    @Bind(R.id.dreamDetailFragment) FrameLayout mDreamDetailLayout;


    private Dream mDream;


    public DreamDetailFragment() {
        // Required empty public constructor
    }

    public static DreamDetailFragment newInstance(Dream dream) {
        DreamDetailFragment dreamDetailFragment = new DreamDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("dream", Parcels.wrap(dream));
        dreamDetailFragment.setArguments(args);
        return dreamDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDream = Parcels.unwrap(getArguments().getParcelable("dream"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dream_detail, container, false);
        ButterKnife.bind(this, view);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
        CharSequence humanDate = dateFormat.format(mDream.getDate());

        mDreamDateTextView.setText(humanDate);
        mDreamDescriptionTextView.setText(mDream.getDescription());


        if (mDream.getColor() != null) {
            int color = Integer.parseInt(mDream.getColor());
            mDreamDetailLayout.setBackgroundColor(color);

            if (Color.red(color)+ "" != null && Color.green(color)+ "" != null && Color.blue(color)+ "" != null && Color.alpha(color)+ "" != null) {
                int alpha =  Color.alpha(color),
                        red = Color.red(color),
                        green = Color.green(color),
                        blue = Color.blue(color);
                if ((red*0.299 + green*0.587 + blue*0.114) > 186 ){
                    mDreamDateTextView.setTextColor((Color.BLACK));
                    mDreamDescriptionTextView.setTextColor(Color.BLACK);
                } else {
                    mDreamDateTextView.setTextColor(Color.WHITE);
                    mDreamDescriptionTextView.setTextColor(Color.WHITE);
                }
            }

        }
        return view;
    }
}

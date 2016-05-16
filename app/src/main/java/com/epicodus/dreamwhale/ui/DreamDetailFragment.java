package com.epicodus.dreamwhale.ui;


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

        mDreamDateTextView.setText(mDream.getDate());
        mDreamDescriptionTextView.setText(mDream.getDescription());
        mDreamDetailLayout.setBackgroundColor(Integer.parseInt(mDream.getColor()));
        return view;
    }
}

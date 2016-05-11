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

public class DreamDescriptionFragment extends Fragment {
    private int page;
    private String description;
    @Bind(R.id.descriptionTextView) TextView mDescriptionTextView;


    public DreamDescriptionFragment() {
        // Required empty public constructor
    }

    public static DreamDescriptionFragment newInstance(int page, String description) {
        DreamDescriptionFragment dreamDescriptionFragment = new DreamDescriptionFragment();
        Bundle args = new Bundle();
        args.putInt("someNewInt", page);
        args.putString("someDescription", description);
        dreamDescriptionFragment.setArguments(args);
        return dreamDescriptionFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ButterKnife.bind(getActivity());
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someNewInt", 2);
        description = getArguments().getString("someDescription");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dream_description, container, false);
        // Inflate the layout for this fragment
        return view;
    }

}

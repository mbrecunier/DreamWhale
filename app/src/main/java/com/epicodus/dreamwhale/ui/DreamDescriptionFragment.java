package com.epicodus.dreamwhale.ui;


import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.models.Dream;
import com.epicodus.dreamwhale.util.Constants;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DreamDescriptionFragment extends BaseFragment implements View.OnClickListener {
    private int page;
    private String description;
    @Bind(R.id.descriptionTextView) TextView mDescriptionTextView;
    @Bind(R.id.submitDreamButton) Button mSubmitDreamButton;
    @Bind(R.id.cancelButton) Button mCancelButton;
    @Bind(R.id.descriptionEditText) EditText mDescriptionEditText;


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
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someNewInt", 2);
        description = getArguments().getString("someDescription");
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dream_description, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);
        mSubmitDreamButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitDreamButton) {
            String date = mSharedPreferences.getString(Constants.DATE, null);
            Log.d("Saved date: ", date + "");
            String color = mSharedPreferences.getString(Constants.COLOR, null);
            Log.d("Saved color: ", color + "");
            String description = mDescriptionEditText.getText().toString();
            Log.d("Saved description ", description + "");

            Dream freshDream = new Dream(date, color, description);


            String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
            Firebase userDreamFirebaseRef = new Firebase(Constants.FIREBASE_DREAMS_URL).child(userUid);
            Firebase pushRef = userDreamFirebaseRef.push();
            String dreamPushId = pushRef.getKey();
            freshDream.setPushID(dreamPushId);
            pushRef.setValue(freshDream);
        }
        if (v == mCancelButton) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }

    }

}

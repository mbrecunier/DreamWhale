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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.models.Dream;
import com.epicodus.dreamwhale.models.User;
import com.epicodus.dreamwhale.util.Constants;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DreamDescriptionFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.submitDreamButton) Button mSubmitDreamButton;
    @Bind(R.id.cancelButton) Button mCancelButton;
    @Bind(R.id.descriptionEditText) EditText mDescriptionEditText;
    @Bind(R.id.privacyCheckBox) CheckBox mPrivacyCheckBox;

    private Dream freshDream = new Dream();


    public static DreamDescriptionFragment newInstance() {
        DreamDescriptionFragment dreamDescriptionFragment = new DreamDescriptionFragment();
        return dreamDescriptionFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dream_description, container, false);
        ButterKnife.bind(this, view);
        mSubmitDreamButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);
        mPrivacyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    freshDream.setPublic(true);
                } else {
                    freshDream.setPublic(false);
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitDreamButton) {
            Long date = mSharedPreferences.getLong(Constants.DATE, 0);
            String color = mSharedPreferences.getString(Constants.COLOR, null);
            String description = mDescriptionEditText.getText().toString();

            freshDream = new Dream(date, color, description, freshDream.getPublic());
            Firebase dreamFirebaseRef = new Firebase(Constants.FIREBASE_DREAMS_URL);
            String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
            dreamFirebaseRef.child(userUid).push().setValue(freshDream);

            Toast.makeText(getActivity(), "dreamWhale saved", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
        if (v == mCancelButton) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    }
}

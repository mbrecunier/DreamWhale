package com.epicodus.dreamwhale.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.util.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.addDreamButton) Button mAddDreamButton;
    @Bind(R.id.viewJournalButton) Button mViewJournalButton;
    @Bind(R.id.viewPublicJournalButton) Button mViewPublicJournalButton;
    @Bind(R.id.welcomeWhale) ImageView mWelcomeWhale;

    private SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAddDreamButton.setOnClickListener(this);
        mViewJournalButton.setOnClickListener(this);
        mViewPublicJournalButton.setOnClickListener(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String color = mSharedPreferences.getString(Constants.COLOR, "#FFFFFF");

        mWelcomeWhale.setColorFilter(Integer.parseInt(color));

    }

    @Override
    public void onClick(View v) {
        if (v == mAddDreamButton) {
            Intent intent = new Intent(MainActivity.this, AddDreamActivity.class);
            startActivity(intent);
        }
        if (v == mViewJournalButton) {
            Intent intent = new Intent(MainActivity.this, SavedDreamsListActivity.class);
            startActivity(intent);
        }
        if (v == mViewPublicJournalButton) {
            Intent intent = new Intent(MainActivity.this, PublicDreamsListActivity.class);
            startActivity(intent);
        }
    }
}

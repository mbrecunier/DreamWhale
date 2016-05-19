package com.epicodus.dreamwhale.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.dreamwhale.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.viewPublicJournalButton) Button mPublicJournalButton;
    @Bind(R.id.loginButton) Button mLoginInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        mPublicJournalButton.setOnClickListener(this);
        mLoginInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        if (v == mPublicJournalButton) {
//            Intent intent = new Intent(LandingActivity.this, PublicDreamsListActivity.class);
//            startActivity(intent);
//        }
//        if (v == mLoginInButton) {
//            Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
//            startActivity(intent);
//        }
    }
}

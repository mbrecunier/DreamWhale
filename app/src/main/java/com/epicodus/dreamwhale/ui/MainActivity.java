package com.epicodus.dreamwhale.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.dreamwhale.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.addDreamButton) Button mAddDreamButton;
    @Bind(R.id.viewJournalButton) Button mViewJournalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAddDreamButton.setOnClickListener(this);
        mViewJournalButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mAddDreamButton) {
            Intent intent = new Intent(MainActivity.this, AddDreamActivity.class);
            startActivity(intent);
        }
        if (v == mViewJournalButton) {
            Intent intent = new Intent(MainActivity.this, ViewDreamsActivity.class);
            startActivity(intent);
        }
    }
}

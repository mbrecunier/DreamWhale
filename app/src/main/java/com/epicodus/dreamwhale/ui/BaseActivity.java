package com.epicodus.dreamwhale.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.epicodus.dreamwhale.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
    private DatabaseReference mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseRef = FirebaseDatabase.getInstance().getReference();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_logged_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
          //TODO: fix firebase logout();
            return true;
        }
        if (id == R.id.action_add_dream) {
            Intent intent = new Intent(this, AddDreamActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_view_personal) {
            Intent intent = new Intent(this, SavedDreamsListActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_view_all) {
            Intent intent = new Intent(this, PublicDreamsListActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //TODO: fix firebase auth
//    protected void logout() {
//        mFirebaseRef.unauth();
//        takeUserToLoginScreenOnUnAuth();
//    }

    private void takeUserToLoginScreenOnUnAuth() {
        Intent intent = new Intent(this, LandingActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}

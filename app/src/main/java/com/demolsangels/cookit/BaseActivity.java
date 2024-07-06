package com.demolsangels.cookit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutResourceId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int item_id = item.getItemId();
            if (item_id == R.id.nav_home) {
                Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else if (item_id == R.id.nav_add) {
                startActivity(new Intent(BaseActivity.this, AddRecipeActivity.class));
            } else if (item_id == R.id.nav_about) {
                startActivity(new Intent(BaseActivity.this, AboutActivity.class));
            }
            return true;
        });
    }
}

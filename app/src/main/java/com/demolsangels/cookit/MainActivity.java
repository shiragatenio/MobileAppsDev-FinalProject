package com.demolsangels.cookit;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Specialties

        RecyclerView viewRecipes = findViewById(R.id.view_specialties);
        viewRecipes.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManagerRecipes = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        viewRecipes.setLayoutManager(layoutManagerRecipes);

        SpecialtyAdapter specialtyAdapter = new SpecialtyAdapter();
        viewRecipes.setAdapter(specialtyAdapter);

        // Kitchens

        RecyclerView viewKitchens = findViewById(R.id.view_kitchens);
        viewKitchens.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManagerKitchens = new GridLayoutManager(this, 3);
        viewKitchens.setLayoutManager(layoutManagerKitchens);

        KitchenAdapter kitchenAdapter = new KitchenAdapter();
        viewKitchens.setAdapter(kitchenAdapter);

    }
}
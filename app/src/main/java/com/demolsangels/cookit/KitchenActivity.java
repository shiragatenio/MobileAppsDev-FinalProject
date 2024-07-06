package com.demolsangels.cookit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class KitchenActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_kitchen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        Kitchen kitchen = (Kitchen) bundle.getSerializable("kitchen");
        assert kitchen != null;

        // Set title

        TextView kitchenTitle = findViewById(R.id.kitchen_title);
        kitchenTitle.setText(String.format("%s Kitchen", kitchen.getName()));

        // Recipes

        RecyclerView viewRecipes = findViewById(R.id.view_recipes);
        viewRecipes.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManagerRecipes = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        viewRecipes.setLayoutManager(layoutManagerRecipes);

        RecipeAdapter specialtyAdapter = new RecipeAdapter(kitchen.getDocumentId());
        viewRecipes.setAdapter(specialtyAdapter);
    }
}

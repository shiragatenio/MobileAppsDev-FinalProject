package com.example.cookit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView viewRecipes = findViewById(R.id.view_recipes);
        viewRecipes.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManagerRecipes = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        viewRecipes.setLayoutManager(layoutManagerRecipes);

        RecipeAdapter recipeAdapter = new RecipeAdapter();
        viewRecipes.setAdapter(recipeAdapter);




        RecyclerView viewKitchens = findViewById(R.id.view_kitchens);
        viewKitchens.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManagerKitchens = new GridLayoutManager(this, 3);
        viewKitchens.setLayoutManager(layoutManagerKitchens);

        KitchenAdapter kitchenAdapter = new KitchenAdapter();
        viewKitchens.setAdapter(kitchenAdapter);


//        Button btn = findViewById(R.id.button);
//        btn.setText("Click Me!");
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //btn.setText("Button Clicked!");
//                Toast.makeText(v.getContext(),"Button Clicked",Toast.LENGTH_LONG).show();
//            }
//        });

    }
}
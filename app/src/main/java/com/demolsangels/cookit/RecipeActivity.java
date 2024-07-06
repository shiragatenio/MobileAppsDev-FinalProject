package com.demolsangels.cookit;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_recipe;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        Recipe recipe = (Recipe) bundle.getSerializable("recipe");
        assert recipe != null;

        // Set title

        TextView recipeTitle = findViewById(R.id.recipe_activity_title);
        recipeTitle.setText(recipe.getName());

        // Set subtitle

        TextView recipeTime = findViewById(R.id.recipe_activity_time);
        recipeTime.setText(recipe.getTimeStr());

        // Set image

        ImageView recipeImage = findViewById(R.id.recipe_activity_image);
        recipe.loadImageIntoImageView(recipeImage);

        // Ingredients

        TextView recipeIngredients = findViewById(R.id.recipe_activity_ingredients);
        recipeIngredients.setText(recipe.getIngredientsStr());

        // Instructions

        TextView recipeInstructions = findViewById(R.id.recipe_activity_instructions);
        recipeInstructions.setText(recipe.getInstructionsStr());
    }
}

package com.demolsangels.cookit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    List<Recipe> recipes;

    public RecipeAdapter(String kitchenId) {
        super();

        recipes = new ArrayList<>();

        FirestoreUtils.getRecipes(kitchenId, recipesList -> {
            recipes.clear();
            recipes.addAll(recipesList);
            notifyDataSetChanged();
        });
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_button, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        recipe.loadImageIntoImageView(holder.Image);
        holder.Name.setText(recipe.getName());
        holder.PrepTime.setText(recipe.getTimeStr());
        holder.Button.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), RecipeActivity.class);
            intent.putExtra("recipe", recipe);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}

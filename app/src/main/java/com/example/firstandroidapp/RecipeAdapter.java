package com.example.firstandroidapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    List<Recipe> Recipes;

    public RecipeAdapter() {
        super();
        Recipes = new ArrayList<>();
        Recipes.add(new Recipe(R.drawable.food1,"Tomato Pasta","25 min", "Italian"));
        Recipes.add(new Recipe(R.drawable.food3,"Pepperoni Pizza","80 min", "Italian"));
        Recipes.add(new Recipe(R.drawable.food2,"Orange Soup","40 min", "Italian"));
        Recipes.add(new Recipe(R.drawable.food4,"Red Spaghetti","25 min", "Italian"));
        Recipes.add(new Recipe(R.drawable.food5,"Caesar Salad","25 min", "Salad"));
        Recipes.add(new Recipe(R.drawable.food5,"Som Tam","25 min", "Asian"));
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe, parent,false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = Recipes.get(position);
        holder.Image.setImageResource(recipe.Image);
        holder.Name.setText(recipe.Name);
        holder.PrepTime.setText(recipe.PrepTime);
    }

    @Override
    public int getItemCount() {
        return Recipes.size();
    }
}

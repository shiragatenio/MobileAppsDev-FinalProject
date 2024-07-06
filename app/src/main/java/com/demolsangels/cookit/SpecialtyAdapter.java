package com.demolsangels.cookit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SpecialtyAdapter extends RecyclerView.Adapter<SpecialtyViewHolder> {

    List<Recipe> recipes;

    public SpecialtyAdapter() {
        super();

        recipes = new ArrayList<>();

        FirestoreUtils.getSpecialties(recipesList -> {
            recipes.clear();
            recipes.addAll(recipesList);
            notifyDataSetChanged();
        });
    }

    @NonNull
    @Override
    public SpecialtyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.specialty_button, parent, false);
        return new SpecialtyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialtyViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        recipe.loadImageIntoImageView(holder.Image);
        holder.Name.setText(recipe.getName());
        holder.PrepTime.setText(recipe.getTimeStr());
        holder.Image.setOnClickListener(v -> {
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

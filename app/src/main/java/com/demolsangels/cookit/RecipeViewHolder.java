package com.demolsangels.cookit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public ImageView Image;
    public TextView Name;
    public TextView PrepTime;
    public CardView Button;

    public RecipeViewHolder(@NotNull View itemView) {
        super(itemView);
        Image = itemView.findViewById(R.id.recipe_image);
        Name = itemView.findViewById(R.id.recipe_name);
        PrepTime = itemView.findViewById(R.id.recipe_time);
        Button = itemView.findViewById(R.id.recipe_card);
    }

}

package com.example.firstandroidapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public ImageView Image;
    public TextView Name;
    public TextView PrepTime;

    public RecipeViewHolder(@NotNull View itemView) {
        super(itemView);
        Image = itemView.findViewById(R.id.image);
        Name = itemView.findViewById(R.id.name);
        PrepTime = itemView.findViewById(R.id.preptime);
    }

}

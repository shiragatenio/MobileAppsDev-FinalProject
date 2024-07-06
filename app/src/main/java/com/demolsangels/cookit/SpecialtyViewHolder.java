package com.demolsangels.cookit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


public class SpecialtyViewHolder extends RecyclerView.ViewHolder {

    public ImageView Image;
    public TextView Name;
    public TextView PrepTime;

    public SpecialtyViewHolder(@NotNull View itemView) {
        super(itemView);
        Image = itemView.findViewById(R.id.specialty_image);
        Name = itemView.findViewById(R.id.specialty_name);
        PrepTime = itemView.findViewById(R.id.specialty_preptime);
    }

}

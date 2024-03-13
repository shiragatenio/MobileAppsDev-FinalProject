package com.example.cookit;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


public class KitchenViewHolder extends RecyclerView.ViewHolder {

    public TextView Name;

    public KitchenViewHolder(@NotNull View itemView) {
        super(itemView);
        Name = itemView.findViewById(R.id.button);
    }

}

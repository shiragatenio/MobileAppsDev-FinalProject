package com.example.cookit;

import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;


public class KitchenViewHolder extends RecyclerView.ViewHolder {

    public Button Button;

    public KitchenViewHolder(@NotNull View itemView) {
        super(itemView);
        Button = itemView.findViewById(R.id.button);
    }

}

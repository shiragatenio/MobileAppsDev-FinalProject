package com.example.cookit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KitchenAdapter extends RecyclerView.Adapter<KitchenViewHolder> {

    List<String> Kitchens;

    public KitchenAdapter() {
        super();
        Kitchens = new ArrayList<>();
        Kitchens.add("Italian");
        Kitchens.add("Salad");
        Kitchens.add("Asian");
        Kitchens.add("Street");
        Kitchens.add("Dessert");
        Kitchens.add("Soups");
    }

    @NonNull
    @Override
    public KitchenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kitchen, parent,false);
        return new KitchenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KitchenViewHolder holder, int position) {
        String kitchen = Kitchens.get(position);
        holder.Name.setText(kitchen);
    }

    @Override
    public int getItemCount() {
        return Kitchens.size();
    }
}

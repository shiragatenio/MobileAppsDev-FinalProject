package com.demolsangels.cookit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KitchenAdapter extends RecyclerView.Adapter<KitchenViewHolder> {

    List<Kitchen> kitchens;

    public KitchenAdapter() {
        super();

        kitchens = new ArrayList<>();

        FirestoreUtils.getKitchens(kitchenList -> {
            kitchens.clear();
            kitchens.addAll(kitchenList);
            notifyDataSetChanged();
        });
    }

    @NonNull
    @Override
    public KitchenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kitchen_button, parent, false);
        return new KitchenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KitchenViewHolder holder, int position) {
        Kitchen kitchen = kitchens.get(position);
        holder.Button.setText(kitchen.getName());
        holder.Button.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), KitchenActivity.class);
            intent.putExtra("kitchen", kitchen);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return kitchens.size();
    }
}

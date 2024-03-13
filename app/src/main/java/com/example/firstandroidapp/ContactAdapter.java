package com.example.firstandroidapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    List<Contact> Contacts;

    public ContactAdapter() {
        super();
        Contacts = new ArrayList<>();
        Contacts.add(new Contact(R.drawable.avatar1,"Contact1","contact1@gmail.com"));
        Contacts.add(new Contact(R.drawable.avatar2,"Contact2","contact2@gmail.com"));
        Contacts.add(new Contact(R.drawable.avatar3,"Contact3","contact3@gmail.com"));
        Contacts.add(new Contact(R.drawable.avatar4,"Contact4","contact4@gmail.com"));
        Contacts.add(new Contact(R.drawable.avatar5,"Contact5","contact5@gmail.com"));
        Contacts.add(new Contact(R.drawable.avatar6,"Contact6","contact6@gmail.com"));
        Contacts.add(new Contact(R.drawable.avatar7,"Contact7","contact7@gmail.com"));
        Contacts.add(new Contact(R.drawable.avatar8,"Contact8","contact8@gmail.com"));
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = Contacts.get(position);
        holder.Avatar.setImageResource(contact.Avatar);
        holder.Name.setText(contact.Name);
        holder.Email.setText(contact.Email);
    }

    @Override
    public int getItemCount() {
        return Contacts.size();
    }
}

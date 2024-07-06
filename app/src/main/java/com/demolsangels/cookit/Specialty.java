package com.demolsangels.cookit;

import com.google.firebase.firestore.DocumentReference;

public class Specialty {
    private DocumentReference recipe;

    public Specialty() {
        // Default constructor required for calls to DataSnapshot.getValue(Specialty.class)
    }

    public Specialty(DocumentReference recipe) {
        this.recipe = recipe;
    }

    public DocumentReference getRecipe() {
        return recipe;
    }

    public void setRecipe(DocumentReference recipe) {
        this.recipe = recipe;
    }
}


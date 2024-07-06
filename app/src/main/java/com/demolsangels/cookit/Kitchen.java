package com.demolsangels.cookit;

import androidx.annotation.NonNull;

import com.google.firebase.firestore.DocumentId;

import java.io.Serializable;

public class Kitchen implements Serializable {
    @DocumentId
    private String documentId;

    private String name;

    public Kitchen() {
        // Default constructor required for calls to DataSnapshot.getValue(Kitchen.class)
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getName() {
        return name;
    }
}

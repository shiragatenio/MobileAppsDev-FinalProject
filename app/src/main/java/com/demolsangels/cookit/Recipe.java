package com.demolsangels.cookit;

import android.net.Uri;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recipe implements Serializable {
    private String name;
    private int time;
    private String image;
    private List<String> ingredients;
    private List<String> instructions;

    public Recipe() {
        // Default constructor required for calls to DataSnapshot.getValue(Recipe.class)
    }

    public Recipe(String name, String ingredients, String instructions) {
        this.name = name;
        this.ingredients = Arrays.asList(ingredients.split("\n"));
        this.instructions = Arrays.asList(instructions.split("\n"));

        // about 5 min per instruction...
        this.time = 5 * this.instructions.size();
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public String getTimeStr() {
        return time + " min";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getIngredientsStr() {
        return make_bullet_list(ingredients, "🍕");
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public String getInstructionsStr() {
        return make_bullet_list(instructions, "🧑🏻‍🍳");
    }

    private static String make_bullet_list(List<String> list, String bullet) {
        return list.stream()
            .map(item -> bullet + " " + item)  // Prepend the bullet to each string
            .collect(Collectors.joining("\n"));  // Join the strings with newline characters
    }

    public void loadImageIntoImageView(ImageView imageView) {
        StorageReference storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(this.image);
        storageRef.getDownloadUrl().addOnSuccessListener(uri -> Picasso.get().load(uri.toString()).into(imageView))
            .addOnFailureListener(Exception::printStackTrace);
    }

    public Map<String, Object> getAsMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("time", time);
        map.put("image", image);
        map.put("ingredients", ingredients);
        map.put("instructions", instructions);
        return map;
    }
}


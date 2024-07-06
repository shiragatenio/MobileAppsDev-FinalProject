package com.demolsangels.cookit;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class FirestoreUtils {

    public interface RecipesCallback {
        void onCallback(List<Recipe> recipeList);
    }

    public static void getRecipes(@NonNull String kitchenId, final RecipesCallback callback) {
        FirebaseFirestore.getInstance()
            .collection("kitchens")
            .document(kitchenId)
            .collection("recipes")
            .get()
            .addOnCompleteListener(task -> {
                if (!task.isSuccessful()) {
                    FirebaseCrashlytics.getInstance().log("Failed to get recipes from " + kitchenId);
                    return;
                }

                List<Recipe> recipeList = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Recipe recipe = document.toObject(Recipe.class);
                    recipeList.add(recipe);
                }

                callback.onCallback(recipeList);
            });
    }

    public static void getSpecialties(final RecipesCallback callback) {
        FirebaseFirestore.getInstance()
            .collection("specialties")
            .get()
            .addOnCompleteListener(task -> {
                if (!task.isSuccessful()) {
                    FirebaseCrashlytics.getInstance().log("Failed to get specialties");
                    return;
                }

                List<Recipe> recipeList = new ArrayList<>();
                List<Task<DocumentSnapshot>> tasks = new ArrayList<>();

                for (QueryDocumentSnapshot document : task.getResult()) {
                    Specialty specialty = document.toObject(Specialty.class);
                    DocumentReference recipeRef = specialty.getRecipe();

                    if (recipeRef != null) {
                        tasks.add(recipeRef.get());
                    }
                }

                Task<List<DocumentSnapshot>> allTasks = Tasks.whenAllSuccess(tasks);
                allTasks.addOnCompleteListener(task1 -> {
                    if (!task1.isSuccessful()) {
                        FirebaseCrashlytics.getInstance().log("Failed to get specialty recipes");
                        return;
                    }

                    for (DocumentSnapshot recipeDoc : task1.getResult()) {
                        if (recipeDoc.exists()) {
                            Recipe recipe = recipeDoc.toObject(Recipe.class);
                            if (recipe != null) {
                                recipeList.add(recipe);
                            }
                        }
                    }
                    callback.onCallback(recipeList);
                });
            });
    }

    public interface KitchensCallback {
        void onCallback(List<Kitchen> kitchenList);
    }

    public static void getKitchens(final KitchensCallback callback) {
        FirebaseFirestore.getInstance()
            .collection("kitchens")
            .get()
            .addOnCompleteListener(task -> {
                if (!task.isSuccessful()) {
                    FirebaseCrashlytics.getInstance().log("Failed to get kitchens");
                    return;
                }

                List<Kitchen> kitchenList = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Kitchen kitchen = document.toObject(Kitchen.class);
                    kitchenList.add(kitchen);
                }

                callback.onCallback(kitchenList);
            });
    }

    public interface AddRecipeDoneCallback {
        void onCallback();
    }

    public static void addUserRecipe(Recipe recipe, Uri image, AddRecipeDoneCallback callback) {
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference fileRef = storageRef.child(image.getPath());

        fileRef.putFile(image).addOnSuccessListener(taskSnapshot -> {
            fileRef.getDownloadUrl().addOnSuccessListener(uri -> {
                recipe.setImage(uri.toString());

                FirebaseFirestore.getInstance()
                    .collection("kitchens")
                    .document("user_recipes")
                    .collection("recipes")
                    .add(recipe.getAsMap());

                callback.onCallback();
            });
        });
    }
}
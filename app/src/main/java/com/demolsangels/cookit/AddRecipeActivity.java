package com.demolsangels.cookit;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class AddRecipeActivity extends BaseActivity {

    int REQUEST_PERMISSIONS_CODE = 1;
    private ActivityResultLauncher<Uri> takePictureLauncher;
    private Uri CurrentImage;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_add_recipe;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Image upload

        ImageView addPhoto = findViewById(R.id.add_recipe_photo);

        takePictureLauncher = registerForActivityResult(new ActivityResultContracts.TakePicture(), result -> {
            if (result) {
                addPhoto.setImageURI(CurrentImage);
            }
        });

        addPhoto.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(AddRecipeActivity.this, new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.ACCESS_MEDIA_LOCATION
                }, REQUEST_PERMISSIONS_CODE);
            } else {
                captureImage();
            }
        });

        // Upload button

        Button upload_btn = findViewById(R.id.add_recipe_submit_button);

        upload_btn.setOnClickListener(v -> {
            String name = ((EditText) findViewById(R.id.add_recipe_name)).getText().toString();
            String ingredients = ((EditText) findViewById(R.id.add_recipe_ingredients)).getText().toString();
            String instructions = ((EditText) findViewById(R.id.add_recipe_instructions)).getText().toString();

            if (name == null || ingredients == null || instructions == null || CurrentImage == null) {
                Toast.makeText(getBaseContext(), "Missing fields", Toast.LENGTH_LONG).show();
                return;
            }

            FirestoreUtils.addUserRecipe(new Recipe(name, ingredients, instructions), CurrentImage, () -> {
//            Intent i = new Intent();
//            i.putExtra("message", c);
//            setResult(1, i);
                finish();
            });
        });
    }

    private Uri createImageUri() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
    }

    public void captureImage() {
        Uri imageUri = createImageUri();
        if (imageUri != null) {
            CurrentImage = imageUri;
            takePictureLauncher.launch(imageUri);
        }
    }
}

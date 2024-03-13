package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(layoutManager);

        RecipeAdapter adapter = new RecipeAdapter();
        rv.setAdapter(adapter);


//        Button btn = findViewById(R.id.button);
//        btn.setText("Click Me!");
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //btn.setText("Button Clicked!");
//                Toast.makeText(v.getContext(),"Button Clicked",Toast.LENGTH_LONG).show();
//            }
//        });

    }
}
package com.example.cookit;

public class Recipe {
    public int Image;
    public String Name;
    public String Kitchen;
    public String PrepTime;

    public Recipe(int image, String name, String prep_time, String kitchen) {
        Image = image;
        Name = name;
        PrepTime = prep_time;
        Kitchen = kitchen;
    }

}

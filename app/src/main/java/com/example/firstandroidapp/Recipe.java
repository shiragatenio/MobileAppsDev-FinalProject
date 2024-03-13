package com.example.firstandroidapp;

public class Recipe {
    public int Image;
    public String Name;
    public String KitchenName;
    public String PrepTime;

    public Recipe(int image, String name, String prep_time, String kitchen) {
        Image = image;
        Name = name;
        PrepTime = prep_time;
        KitchenName = kitchen;
    }

}

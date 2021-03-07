package com.example.foodforyou;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

//    private String name;
//    private String id;
//    private int timeToMake;

    // Taken from Spoonacular.com/food-api/docs JSON documentation.
    private int id;
    private int calories;
    private String carbs;
    private String fat;
    private String image;
    private String imageType;
    private String protein;
    private String title;

//    private String author;
//    private String cuisine;
//    private String description;

    // Constructor takes information using fromJsonArray, pass into constructor.

    // Empty constructor (for random case we use Parser).
    public Recipe() {}

    public Recipe(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getInt("id");
        calories= jsonObject.getInt("calories");
        carbs = jsonObject.getString("carbs");
        fat = jsonObject.getString("fat");
        image = jsonObject.getString("id");
        imageType = jsonObject.getString("imageType");
        protein = jsonObject.getString("protein");
        title = jsonObject.getString("title");

    }

    // Create list of Recipes.
    public static List<Recipe> fromJsonArray(JSONArray recipeJsonArray) throws JSONException {
        List<Recipe> recipes = new ArrayList<>();
        for(int i = 0; i < recipeJsonArray.length(); i++) {
            recipes.add(new Recipe(recipeJsonArray.getJSONObject(i)));
        }
        return recipes;
    }

    // Getter methods.
    public int getId() {
        return id;
    }

    public int getCalories() {
        return calories;
    }

    public String getCarbs() {
        return carbs;
    }

    public String getFat() {
        return fat;
    }

    public String getImage() {
        return image;
    }

    public String getImageType() {
        return imageType;
    }

    public String getProtein() {
        return protein;
    }

    public String getTitle() {
        return title;
    }
}

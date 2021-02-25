package com.example.foodforyou.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodforyou.R;
import com.example.foodforyou.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{

    Context context;
    List<Recipe> recipes;

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    // Inflate layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recipeView = LayoutInflater.from(context).inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(recipeView);
    }

    // Populate  Data
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get recipe
        Recipe recipe = recipes.get(position);
        // Bind recipe data into view holder
        holder.bind(recipe);
    }

    // Total count of items in list
    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRecipeName;
        TextView tvRecipeOverview;
        ImageView ivPicture;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRecipeName = itemView.findViewById(R.id.tvRecipeName);
            tvRecipeOverview = itemView.findViewById(R.id.tvRecipeOverview);
            ivPicture = itemView.findViewById(R.id.ivPicture);
        }

        public void bind(Recipe recipe) {
            //TODO

            // Flixter episode 3, 16:40
            // Use methods from Recipe.java
            // Finish Recipe.java

        }
    }
}

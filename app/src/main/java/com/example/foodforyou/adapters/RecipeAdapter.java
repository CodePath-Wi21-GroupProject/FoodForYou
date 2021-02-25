package com.example.foodforyou.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter {

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRecipeName;
        TextView tvRecipeOverview;
        ImageView ivPicture;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

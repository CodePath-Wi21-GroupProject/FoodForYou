package com.example.foodforyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    EditText etSearch;
    Button btnSearch;
    List<Recipe> recipes;
    private JSONArray testArr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBYName(etSearch.getText().toString());
            }
        });
    }

    private void searchBYName(String searchText){
        recipes = new ArrayList<>();
        String url = "https://api.spoonacular.com/recipes/complexSearch?query=" + searchText + "&number=20&instructionsRequired=true&apiKey=500ef1f8b4484ebb90d47c6eb7226c39";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    testArr = response.getJSONArray("results");
                    Log.i(TAG, "Response : " + String.valueOf(testArr));
                    for (int i = 0; i < testArr.length(); i++){
                        JSONObject object;
                        object = testArr.getJSONObject(i);
                        Recipe recipe = new Recipe( object.optString("name"), object.optString("id"), object.optString("image"), 0);
                        recipes.add(recipe);
                    }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Response : " + String.valueOf(testArr));
                Log.e(TAG, "response error:"+ error.toString());
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}

package com.example.foodforyou;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.foodforyou.fragments.HomeFragment;
import com.example.foodforyou.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Headers;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private static final String API_KEY = "8707942b183d4de4ba74d03a50f475b6";
    private static final String baseEndpoint = "https://api.spoonacular.com/recipes/complexSearch?apiKey=" + API_KEY;

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("query", "pasta");

        client.get(baseEndpoint, params, new JsonHttpResponseHandler() {
                //@Override
                public void onSuccess(int statusCode, Headers headers, com.codepath.asynchttpclient.callback.JsonHttpResponseHandler.JSON json) throws JSONException {

                    // Access JSON array response.
//                    Log.d("DEBUG ARRAY", json.toString());
//                    // Access JSON object response.
//                    Log.d("DEBUG OBJECT", json.toString());

                    Log.d(TAG, "onSuccess");
                    JSONObject jsonObject = json.jsonObject;
                    try {
                        JSONArray results = jsonObject.getJSONArray("results");
                        Log.i(TAG, "Results: " + results.toString());
                    } catch (JSONException e) {
                        Log.e(TAG, "Hit json exception", e);
                        e.printStackTrace();
                    }
                }
                //@Override
                public void onFailure(int statusCode, Headers headers, String errorResponse, Throwable t) {
                    Log.e(TAG, "Hit json exception", t);
                }
            });



        /**
         * Bottom View Navigation
         * Tab functionality - swap between Home and Search
         */
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        fragment = new HomeFragment();
                        break;

                    case R.id.action_search:
                        Toast.makeText(MainActivity.this, "Search!", Toast.LENGTH_SHORT).show();
                        fragment = new SearchFragment();
                        break;
                }
                //fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                return true;
            }
        });

        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}

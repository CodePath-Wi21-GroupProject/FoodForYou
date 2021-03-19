package com.example.foodforyou.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.foodforyou.R;

public class SearchFragment extends Fragment {
    Button mButton;
    EditText mEdit;
    TextView mText;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton = view.findViewById(R.id.btSubmit);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEdit   = view.findViewById(R.id.searchBar);
                mText = view.findViewById(R.id.searchMsg);

            }
        });
    }
}
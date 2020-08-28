package com.thohao.floatingactionbutton_autohide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton mFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mFloatingActionButton = findViewById(R.id.fab);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        CountryAdapter countryAdapter = new CountryAdapter(fetchCountryInfo());
        mRecyclerView.setAdapter(countryAdapter);

        //hide fab when scrolling
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && mFloatingActionButton.getVisibility() == View.VISIBLE) {
                    mFloatingActionButton.hide();
                } else if (dy < 0 && mFloatingActionButton.getVisibility() != View.VISIBLE) {
                    mFloatingActionButton.show();
                }
            }
        });
    }

    private List<Country> fetchCountryInfo() {
        List<Country> countryList = new ArrayList<>();
        String[] arrName = getResources().getStringArray(R.array.arr_countries);
        String[] arrDescription = getResources().getStringArray(R.array.arr_countries_description);
        for (int i = 0; i < arrName.length; i++) {
            Country country = new Country();
            country.setName(arrName[i]);
            country.setDescription(arrDescription[i]);
            countryList.add(country);
        }
        return countryList;
    }


}
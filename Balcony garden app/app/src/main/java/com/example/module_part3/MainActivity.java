package com.example.module_part3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myListView;
    MaterialToolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setting the default layout and menu
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topAppBar = findViewById(R.id.appbar);

        //topAppBar.setNavigationOnClickListener();

        //Resources res = getResources();
        // Creating the list of plants and the adapter to show items
        myListView = findViewById(R.id.listView);

        List<PlantData> plantList = new ArrayList<>();

        plantList.add(new PlantData("Paprika", "Making fruit", "2e"));
        plantList.add(new PlantData("Tomato", "Seedling", "1e"));
        plantList.add(new PlantData("Chili", "Sappling", "3e"));

        ItemAdapter itemAdapter = new ItemAdapter(this, plantList);
        myListView.setLayoutManager(new LinearLayoutManager(this));
        myListView.setAdapter(itemAdapter);
    }
}
package com.example.module_part3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
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
package com.example.module_part3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myListView;

    public static List<PlantData> plantList = new ArrayList<>();

    Toolbar topAppBar;
    FragmentContainerView navController;
    ClipData.Item addPlant;
    ClipData.Item myPlants;
    ClipData.Item info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setting the default layout and menu
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Balcony garden");


        // Creating the list of plants and the adapter to show items
        myListView = findViewById(R.id.listView);

        /*** Example plants for quick testing!
        plantList.add(new PlantData("Paprika", "Making fruit", "Water often"));
        plantList.add(new PlantData("Tomato", "Seedling", "Water few times a week"));
        plantList.add(new PlantData("Chili", "Sappling", "Water few times a week"));*/

        ItemAdapter itemAdapter = new ItemAdapter(this, plantList);
        myListView.setLayoutManager(new LinearLayoutManager(this));
        myListView.setAdapter(itemAdapter);

    }

        // Handling menu navigation
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem item1 = menu.findItem(R.id.mainActivity);
        Intent intent1 = new Intent(this, MainActivity.class);
        item1.setIntent(intent1);

        MenuItem item2 = menu.findItem(R.id.addPlant);
        Intent intent2 = new Intent(this, AddPlant.class);
        item2.setIntent(intent2);

        MenuItem item3 = menu.findItem(R.id.info);
        Intent intent3 = new Intent(this, Info.class);
        item3.setIntent(intent3);

        return true;
    }



}
package com.example.module_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class AddPlant extends AppCompatActivity{
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setting the default layout and menu
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_plant);
        getSupportActionBar().setTitle("Balcony garden");

        addButton = findViewById(R.id.saveButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            addPlant();
            }
        });

    }

    public void addPlant() {
        List<PlantData> plantList = MainActivity.plantList;
        //plantList.add(new PlantData("Onion", "Sappling", "Water few times a week"));

    }

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

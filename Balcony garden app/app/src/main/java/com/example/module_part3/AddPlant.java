package com.example.module_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class AddPlant extends AppCompatActivity{
    Button addButton;
    EditText editName;
    RadioGroup status;
    RadioGroup watering;

    RadioButton statusButton;
    RadioButton waterButton;


    PlantData addNew;

    String plantName;
    String plantStatus;
    String plantWatering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setting the default layout and menu
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_plant);
        getSupportActionBar().setTitle("Balcony garden");

        addButton = findViewById(R.id.saveButton);
        editName = findViewById(R.id.plantName);
        status = findViewById(R.id.plantStatus);
        watering = findViewById(R.id.plantWatering);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            addPlant();
            }
        });

    }

    // Add information to a new Plantdata item and add it to the list
    public void addPlant() {
        List<PlantData> plantList = MainActivity.plantList;
        plantName = editName.getText().toString();

        int statusId = status.getCheckedRadioButtonId();
        statusButton = findViewById(statusId);
        plantStatus = statusButton.getText().toString();

        int waterId = watering.getCheckedRadioButtonId();
        waterButton = findViewById(waterId);
        plantWatering = waterButton.getText().toString();

        addNew = new PlantData(plantName, plantStatus, plantWatering);
        plantList.add(addNew);


    }
    public void checkButton(View view){
        int statusId = status.getCheckedRadioButtonId();
        int waterId = watering.getCheckedRadioButtonId();

        statusButton = findViewById(statusId);
        waterButton = findViewById(waterId);
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

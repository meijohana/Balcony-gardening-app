package com.example.module_part3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setting the default layout and menu
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        getSupportActionBar().setTitle("Balcony garden");
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

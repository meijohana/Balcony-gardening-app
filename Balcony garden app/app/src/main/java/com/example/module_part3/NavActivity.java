package com.example.module_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button secondActivity = (Button)findViewById(R.id.secondActivity);
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("com.example.module_part3.nav", "HELLO NEW LIFE");
                startActivity(startIntent);
            }
        });

        Button google = (Button)findViewById(R.id.firstActivity);
        google.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String googleString = "http://www.google.com";
                Uri webaddress = Uri.parse(googleString);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoGoogle);
                }
            }
        });
    }


}
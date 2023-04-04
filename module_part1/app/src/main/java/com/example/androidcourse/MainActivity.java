package com.example.androidcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addButton);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstEditText = (EditText) findViewById(R.id.firstEditText);
                EditText secondEditText = (EditText) findViewById(R.id.secondEditText);
                TextView resultText = (TextView) findViewById(R.id.resultText);

                int num1 = Integer.parseInt(firstEditText.getText().toString());
                int num2 = Integer.parseInt(secondEditText.getText().toString());
                int result = num1 + num2;
                resultText.setText(String.valueOf(result));
            }
        });
    }
}
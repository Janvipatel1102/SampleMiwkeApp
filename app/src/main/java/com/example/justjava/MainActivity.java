package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String buttonCLicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button number = (Button) findViewById(R.id.number);

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,numberActivity.class );
                intent.putExtra(buttonCLicked,"number");
                startActivity(intent);
            }
        });
       Button family = (Button) findViewById(R.id.family);

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,family.class );
                startActivity(intent);
            }
        });
        Button colors = (Button) findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,colorsActivity.class );
              //  intent.putExtra(buttonCLicked,"colors");
                startActivity(intent);
            }
        });
        Button phrases = (Button) findViewById(R.id.phrases);

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,phrase.class );
                //intent.putExtra(buttonCLicked,"phrases");
                startActivity(intent);
            }
        });




    }
}
package com.example.dhanlabh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Intent getting_intent = ;
        String toolbarTitle = getIntent().getStringExtra(MainActivity.INTENT_STRING);    // getting string from first activity
        toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle(toolbarTitle); // this will set title to Action Bar which will be intent coming from activity1
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);
        }
        toolbar.setTitle(toolbarTitle);
    }
}
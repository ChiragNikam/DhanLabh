package com.example.dhanlabh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2_Expense_Entries extends AppCompatActivity {
    Toolbar toolbar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_expence_entries);

        // adding and setting toolbar
        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);  // back button on toolbar
        }

    }

    public void startExpenseEntries(View view){
        Intent intent = new Intent(this, Activity2_1_Input_Expense_Entries.class);
        startActivity(intent);
    }

}

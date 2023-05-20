package com.example.dhanlabh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExpenseEntry extends AppCompatActivity {
    Toolbar toolbar3;
    EditText edit_text_amount;
    EditText edit_text_category;
    public static String INTENT_AMOUNT = "com.example.dhanlabh.amount.spent";
    public static String INTENT_CATEGORY = "com.example.dhanlabh.expence.category";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expence_entry);
        toolbar3 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);  // set back button on toolbar
        }
        toolbar3.setTitle("Expense Entry Record");
    }
    public void cancelButton(View view){    // go back if user hits cancel button
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void addExpenseEntry(View view){ // function for adding manual entry to expence
        edit_text_amount = findViewById(R.id.editTextAmount);
        int amount = Integer.parseInt(edit_text_amount.getText().toString());
        edit_text_category = findViewById(R.id.editTextCategory);
        String category = edit_text_category.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(INTENT_AMOUNT, amount);
        intent.putExtra(INTENT_CATEGORY, category);
        startActivity(intent);  // directing to MainActivity2 and sending intent data to previous activity
    }
}
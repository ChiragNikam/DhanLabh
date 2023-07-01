package com.example.dhanlabh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);
    }
    public void gotoExpenseEntries(View view){ // directing to 2nd activity for Income and Expence
        Intent intent = new Intent(this, Activity2_Expense_Entries.class);
        startActivity(intent);
    }
}

package com.example.dhanlabh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {
    Toolbar toolbar;
    ListView lstView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Setting Toolbar with its title and back button on it
        String toolbarTitle = getIntent().getStringExtra(MainActivity.INTENT_STRING);    // getting string from first activity
        toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle(toolbarTitle); // this will set title to Action Bar which will be intent coming from activity1
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);  // set backbutton on toolbar
        }

        // Setting Custom Adapter
        ExpensesHistoryLayout expensesHistoryLayout = new ExpensesHistoryLayout(this, R.layout.expenses_history_layout, "Daru", 25);
        lstView = findViewById(R.id.expense_entrys);    // entries will show in list view named expense_entry
        lstView.setAdapter(expensesHistoryLayout);
    }
    public void startExpenseEntry(View view){   // start activity ExpenseEntry for manual entry of expences
        Intent intent = new Intent(this, ExpenseEntry.class);
        startActivity(intent);
        Toast.makeText(this, "after clicking add button", Toast.LENGTH_SHORT).show();
    }
}
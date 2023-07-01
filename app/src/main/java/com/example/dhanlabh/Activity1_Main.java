package com.example.dhanlabh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Activity1_Main extends AppCompatActivity {
    public static final String INTENT_STRING = "com.example.dhanlabh.sending_intent";
    public ArrayList<String> exp_category = new ArrayList<String>();    // this will store category of expense.
    public ArrayList<Integer> exp_amount = new ArrayList<Integer>();    // this will store amount of expense
//    public String[] contents_of_list_view = {"Income and Expenses", "Transaction History", "Budget Analysis", "Goal Tracker"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);
        exp_category.add("Daru");   // adding entry of category to the array list
        exp_amount.add(20);         // adding entry of amount to the array list
    }
    public void gotoExpenseEntries(View view){ // directing to 2nd activity for Income and Expence
        Intent intent = new Intent(this, Activity2_Expense_Entries.class);
        startActivity(intent);
    }
//    public void gotoYourSpendings(View view){   // directing to 2nd activity for Spendings
//        Intent intent = new Intent(this, );
//        intent.putExtra(INTENT_STRING, "Your Spendings");
//        startActivity(intent);
//    }
//    public void gotoYourBudgets(View view){ // directing to 2nd activity for Budgets
//        Intent intent = new Intent(this, );
//        intent.putExtra(INTENT_STRING, "Your Budget");
//        startActivity(intent);
//    }
//    public void gotoTrackAndSetGoals(View view){    // directing to 2nd activity for Future Financial Goals
//        Intent intent = new Intent(this, );
//        intent.putExtra(INTENT_STRING, "Track and Set Goals");
//        startActivity(intent);
//    }
}
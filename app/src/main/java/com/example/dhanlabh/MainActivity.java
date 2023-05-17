package com.example.dhanlabh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    public static final String INTENT_STRING = "com.example.dhanlabh.sending_intent";
    public String[] contents_of_list_view = {"Income and Expenses", "Transaction History", "Budget Analysis", "Goal Tracker"};
    public ListView lstOptions;
    public Button btnGoToSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gotoIncomeAndExpense(View view){ // directing to 2nd activity for Income and Expence
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(INTENT_STRING, "Expenses and History");
        startActivity(intent);
    }
    public void gotoYourSpendings(View view){   // directing to 2nd activity for Spendings
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(INTENT_STRING, "Your Spendings");
        startActivity(intent);
    }
    public void gotoYourBudgets(View view){ // directing to 2nd activity for Budgets
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(INTENT_STRING, "Your Budget");
        startActivity(intent);
    }
    public void gotoTrackAndSetGoals(View view){    // directing to 2nd activity for Future Financial Goals
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(INTENT_STRING, "Track and Set Goals");
        startActivity(intent);
    }
}
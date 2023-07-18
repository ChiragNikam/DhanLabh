package com.example.dhanlabh;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Activity1_Main extends AppCompatActivity {
    ImageView image_sip, image_finance, image_save_money;
    TextView txt_sip, txt_finance, txt_save_money;
    Button btn_expenses_and_history, btn_your_spending, btn_your_budget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);
        // setting image views
        image_sip = findViewById(R.id.img_sip);
        image_finance = findViewById(R.id.img_improve_finance);
        image_save_money = findViewById(R.id.img_save_money);

        // setting text views
        txt_sip = findViewById(R.id.txt_sip);
        txt_finance = findViewById(R.id.txt_improve_finance);
        txt_save_money = findViewById(R.id.txt_save_money);

        // opening article for SIP
        image_sip.setOnClickListener(v -> {
            openLinkInBrowser("https://expensesmanager.in/articles/lumpsum-vs-sip");
        });
        txt_sip.setOnClickListener(v -> {
            openLinkInBrowser("https://expensesmanager.in/articles/lumpsum-vs-sip");
        });

        // opening article for Financial Health
        image_finance.setOnClickListener(v -> {
            openLinkInBrowser("https://www.investopedia.com/articles/personal-finance/111813/five-rules-improve-your-financial-health.asp");
        });
        txt_finance.setOnClickListener(v -> {
            openLinkInBrowser("https://www.investopedia.com/articles/personal-finance/111813/five-rules-improve-your-financial-health.asp");
        });

        // opening article for Saving Money
        image_save_money.setOnClickListener(v -> {
            openLinkInBrowser("https://www.thebalancemoney.com/the-complete-beginner-s-guide-to-saving-money-358065");
        });
        txt_save_money.setOnClickListener(v -> {
            openLinkInBrowser("https://www.thebalancemoney.com/the-complete-beginner-s-guide-to-saving-money-358065");
        });

        // setting buttons
        btn_expenses_and_history = findViewById(R.id.btn_Expenses_History);
        btn_your_spending = findViewById(R.id.btn_Your_Spendings);
        btn_your_budget = findViewById(R.id.btn_Your_Budgets);

        btn_expenses_and_history.setOnClickListener(v -> {
            gotoExpenseEntries();
        });
        btn_your_spending.setOnClickListener(v -> {
            showCategories();
        });
    }
    public void gotoExpenseEntries(){ // directing to 2nd activity for Income and Expense
        Intent intent = new Intent(this, Activity2_Expense_Entries.class);
        startActivity(intent);
    }
    public void showCategories(){
        Intent intent = new Intent(this, Activity3_YourSpendings.class);
        intent.putExtra("to-do", "Categories");
        startActivity(intent);
    }
    public void openLinkInBrowser(String url){ // explecit intent
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Toast.makeText(this, "No application available to open the website.", Toast.LENGTH_SHORT).show();
        }
    }
}
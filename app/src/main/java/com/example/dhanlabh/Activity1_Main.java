package com.example.dhanlabh;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1_Main extends AppCompatActivity {
    ImageView image_sip, image_finance, image_save_money;
    TextView txt_sip, txt_finance, txt_save_money;
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
    }
    public void gotoExpenseEntries(View view){ // directing to 2nd activity for Income and Expense
        Intent intent = new Intent(this, Activity2_Expense_Entries.class);
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
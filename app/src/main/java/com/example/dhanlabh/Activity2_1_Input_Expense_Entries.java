package com.example.dhanlabh;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dhanlabh.a_Entities.ExpenseEntries;
import com.example.dhanlabh.c_Database.ExpenseDb_helper;
import java.util.Calendar;

public class Activity2_1_Input_Expense_Entries extends AppCompatActivity {
    Button btn_add, btn_cancel;
    TextView textView_Category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_1_input_expenses);
        String to_do = getIntent().getStringExtra("to-do");

        String category = "";
        int id = 0;
        double amount = 0;
        String date = "";

        if(to_do.equals("category")){
            EditText txt_cat = findViewById(R.id.edit_text_amount);
            category = getIntent().getStringExtra("category_name");
            String saved_amount = getIntent().getStringExtra("saved_amount");
            textView_Category = findViewById(R.id.txtView_categoryName);
            textView_Category.setText(category);
            txt_cat.setText(saved_amount);
        }

        if(to_do.equals("update")){ // if intent to update, set data to the editText.
            category = getIntent().getStringExtra("type");
            id = getIntent().getIntExtra("id", 0);
            amount = getIntent().getDoubleExtra("amount", 0);
            date = getIntent().getStringExtra("date");

            btn_add = findViewById(R.id.btn_add_to_Database);
            btn_add.setText("Update");
            Log.d("insert_data", "category: " + category + ", amount: " + amount + ", date: " + date + ", id: " + id);

            textView_Category = findViewById(R.id.txtView_categoryName);
            textView_Category.setText(category);

            EditText etAmount = findViewById(R.id.edit_text_amount);
            etAmount.setText(String.valueOf(amount));
        } else {
            btn_add = findViewById(R.id.btn_add_to_Database);
        }
        int finalId = id;
        String finalDate = date;
        btn_add.setOnClickListener(view -> {
                        if (btn_add.getText().toString().equalsIgnoreCase("add")){
                            onAdd();
                        }
                        else if(btn_add.getText().toString().equalsIgnoreCase("update")){
                            onUpdate(finalId, finalDate);
                        }
                    Intent intent = new Intent(this, Activity2_Expense_Entries.class);
                    startActivity(intent);
                    finish();
        });

        // Action over CANCEL button
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(view -> {
            Intent goBack = new Intent(Activity2_1_Input_Expense_Entries.this, Activity2_Expense_Entries.class);
            startActivity(goBack);
            finish();
        });

        LinearLayoutCompat lstCategories = findViewById(R.id.lst_category);
        lstCategories.setOnClickListener(v -> {
            EditText txt_amount = findViewById(R.id.edit_text_amount);
            Intent intent = new Intent(this, Activity3_YourSpendings.class);
            intent.putExtra("category", "chose category");
            intent.putExtra("saved_amount", txt_amount.getText().toString());
            startActivity(intent);
        });

    }

    public void onUpdate(int id, String date){
        TextView categoryEditText = findViewById(R.id.txtView_categoryName);
        String category = categoryEditText.getText().toString();
        EditText amountEditText = findViewById(R.id.edit_text_amount);
        double amount = Double.parseDouble(amountEditText.getText().toString());

         ExpenseDb_helper expenseDb_helper = ExpenseDb_helper.getDb(this);
        expenseDb_helper.expenseEntries_dao().updateExpenseEntries(new ExpenseEntries(
                id, category, amount, date
        ));
    }
    public void onAdd() {
        // Expense Category
        textView_Category = findViewById(R.id.txtView_categoryName);
        String category = null;
            category = textView_Category.getText().toString();

        // Expense Amount
        EditText amountEditText = findViewById(R.id.edit_text_amount);
        double amount = 0;
        if (!amountEditText.getText().toString().equals("")) {
            amount = Double.parseDouble(amountEditText.getText().toString());
        } else {
            Toast.makeText(this, "Please mention Expense Amount", Toast.LENGTH_SHORT).show();
        }

        // Expense Date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Note: Month starts from 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String currentDate = day + "-" + month + "-" + year;

        ExpenseDb_helper expenseDb_helper = ExpenseDb_helper.getDb(this);
        expenseDb_helper.expenseEntries_dao().insertExpenseEntries(new ExpenseEntries(
                category, amount, currentDate
        ));
    }
}
package com.example.dhanlabh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.dhanlabh.Data.DbHandler;
import com.example.dhanlabh.Model.DbEntriesHandler;
import java.util.Calendar;
import java.util.List;

public class Activity2_1_Input_Expense_Entries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_1_input_expenses);
    }

    public void onAdd(View view){
        // Expense Category
        EditText categoryEditText = findViewById(R.id.edit_text_category);
        String category = categoryEditText.getText().toString();
        // Expense Amount
        EditText amountEditText = findViewById(R.id.edit_text_amount);
        double amount = Double.parseDouble(amountEditText.getText().toString());
        // Expense Date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Note: Month starts from 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String currentDate = day + "-" + month + "-" + year;

        DbEntriesHandler dbEntriesHandler = new DbEntriesHandler();
        dbEntriesHandler.setExp_type(category);
        dbEntriesHandler.setExp_amount(amount);
        dbEntriesHandler.setExp_date(currentDate);

        try(DbHandler dbHandler = new DbHandler(Activity2_1_Input_Expense_Entries.this)){

            dbHandler.addEntry(dbEntriesHandler);
            Log.d("insert_entries", "data inserted sucessfully.");
            List<DbEntriesHandler> table_data = dbHandler.getAllEntries();    // getting all rows of the table in a list

            for (DbEntriesHandler exp : table_data) {   // reading all entries in list
                Log.d("insert_data", "id: " + exp.getId() + ", expense type: " + exp.getExp_type() + ", expense amount: " + exp.getExp_amount() + ", expense date: " + exp.getExp_date());
            }

            Intent intent = new Intent(this, Activity2_Expense_Entries.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Exception Occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
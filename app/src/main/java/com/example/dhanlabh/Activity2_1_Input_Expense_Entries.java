package com.example.dhanlabh;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.dhanlabh.Data.DbHandler;
import com.example.dhanlabh.Model.DbEntriesHandler;
import java.util.Calendar;
import java.util.List;

public class Activity2_1_Input_Expense_Entries extends AppCompatActivity {
    Button btn_add, btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_1_input_expenses);
        String to_do = getIntent().getStringExtra("to-do");

        String category = "";
        int id = 0;
        double amount = 0;
        String date = "";
        if(to_do.equals("update")){ // if intent to update, set data to the editText.
            category = getIntent().getStringExtra("type");
            id = getIntent().getIntExtra("id", 0);
            amount = getIntent().getDoubleExtra("amount", 0);
            date = getIntent().getStringExtra("date");

            btn_add = findViewById(R.id.btn_add_to_Database);
            btn_add.setText("Update");
            Log.d("insert_data", "category: " + category + ", amount: " + amount + ", date: " + date + ", id: " + id);

            EditText etCategory = findViewById(R.id.edit_text_category);
            etCategory.setText(category);

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
                    }
            );

            // Action over CANCEL button
            btn_cancel = findViewById(R.id.btn_cancel);
            btn_cancel.setOnClickListener(view -> {
                Intent goBack = new Intent(Activity2_1_Input_Expense_Entries.this, Activity2_Expense_Entries.class);
                startActivity(goBack);
                finish();
            });
    }

    public void onUpdate(int id, String date){
        EditText categoryEditText = findViewById(R.id.edit_text_category);
        EditText amountEditText = findViewById(R.id.edit_text_amount);

        // Setting data to the object
        DbEntriesHandler updated_data = new DbEntriesHandler();
        updated_data.setId(id);
        updated_data.setExp_amount(Double.parseDouble(amountEditText.getText().toString()));
        updated_data.setExp_type(categoryEditText.getText().toString());
        updated_data.setExp_date(date);

        // Setting data to table/database
        try(DbHandler update_record = new DbHandler(this)){
            update_record.updateEntries(updated_data);
        }
    }
    public void onAdd() {
        // Expense Category
        EditText categoryEditText = findViewById(R.id.edit_text_category);
        String category = null;
        if (!categoryEditText.getText().toString().equals("")) {
            category = categoryEditText.getText().toString();
        } else {
            Toast.makeText(this, "Please mention Expense Category", Toast.LENGTH_SHORT).show();
        }
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

        DbEntriesHandler dbEntriesHandler = new DbEntriesHandler();
        dbEntriesHandler.setExp_type(category);
        dbEntriesHandler.setExp_amount(amount);
        dbEntriesHandler.setExp_date(currentDate);

        try (DbHandler dbHandler = new DbHandler(Activity2_1_Input_Expense_Entries.this)) {
            dbHandler.addEntry(dbEntriesHandler);
            Log.d("insert_entries", "data inserted successfully.");
            List<DbEntriesHandler> table_data = dbHandler.getAllEntries();    // getting all rows of the table in a list

            for (DbEntriesHandler exp : table_data) {   // reading all entries in list
                Log.d("insert_data", "id: " + exp.getId() + ", expense type: " + exp.getExp_type() + ", expense amount: " + exp.getExp_amount() + ", expense date: " + exp.getExp_date());
            }

        } catch (Exception e) {
            Toast.makeText(this, "Exception Occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
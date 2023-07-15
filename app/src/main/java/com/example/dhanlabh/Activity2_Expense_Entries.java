package com.example.dhanlabh;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dhanlabh.Data.DbHandler;
import com.example.dhanlabh.Model.DbEntriesHandler;
import java.util.List;

public class Activity2_Expense_Entries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_expence_entries);

        // adding and setting toolbar
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);  // back button on toolbar
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        try(DbHandler expenseEntries = new DbHandler(this)) {
            List<DbEntriesHandler> dataList = expenseEntries.getAllEntries();
            // Add data to dataList
            // ...

            ExpenseHistoryAdapter adapter = new ExpenseHistoryAdapter(dataList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }

    public void startExpenseEntries(View view){
        Intent intent = new Intent(this, Activity2_1_Input_Expense_Entries.class);
        intent.putExtra("to-do", "add");
        startActivity(intent);
    }

    @Override   // bug_fix - solution for bug - 16c12da
    public void onBackPressed() {
        // Start Activity1_Main when back button is pressed
        Intent intent = new Intent(this, Activity1_Main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        startActivity(intent);
        finish(); // Finish the current activity
    }
}

package com.example.dhanlabh;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dhanlabh.a_Entities.ExpenseCategories;
import com.example.dhanlabh.c_Database.ExpenseDb_helper;

import java.util.List;

public class Activity3_ExpCategories extends AppCompatActivity {
    public static boolean isInitialInsertionDone = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_exp_categories);

        String intent_str = getIntent().getStringExtra("from_activity1");
        String saved_amount = getIntent().getStringExtra("saved_amount");
        Log.d("intent", "" + intent_str);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView categoryRecycler = findViewById(R.id.recyclerCategories);

        ExpenseDb_helper expenseDb_helper = ExpenseDb_helper.getDb(this);

        List<ExpenseCategories> categoriesList = expenseDb_helper.categories_dao().getAllCategories();
        // inserting categories only if the table is empty and just created
        if(categoriesList.isEmpty()) {
            expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Others", "Miscellaneous expenses"));
            expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Food and Dining", "Groceries, dairy products, restaurant bills, etc."));
            expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Shopping", "Apparels shopping, Appliances shopping, etc."));
            expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Education", "Tuition fees, school fees, courses, etc."));
            expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Gifts and Donation", "Gifts, donations, birthdays, etc."));
            expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Medical", "Doctors bills, medical bills, etc."));
            expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Investments", "Stocks, bonds, mutual funds, etc."));
            Log.d("database", "performed insertion");
        }

        categoriesList = expenseDb_helper.categories_dao().getAllCategories();
        CategoriesAdapter adapter = new CategoriesAdapter(categoriesList, saved_amount);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        categoryRecycler.setAdapter(adapter);
        Log.d("database", "categories");
        for(ExpenseCategories e : categoriesList){
           Log.d("database", "id: " + e.getCategory_id() +
                   ", category_name: " + e.getCategory_name() +
                   ", category_desc: " + e.getCategory_description());
        }
    }
}
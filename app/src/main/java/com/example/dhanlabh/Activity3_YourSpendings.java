package com.example.dhanlabh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dhanlabh.a_Entities.ExpenseCategories;
import com.example.dhanlabh.c_Database.ExpenseDb_helper;

import java.util.List;

public class Activity3_YourSpendings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_your_spendings);
        String intent = getIntent().toString();
        Log.d("intent", intent);

        RecyclerView categoryRecycler = findViewById(R.id.recyclerCategories);

        ExpenseDb_helper expenseDb_helper = ExpenseDb_helper.getDb(this);

        expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                "Others", "Miscellaneous expenses"));
        expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                "Food and Dining", "Groceries, dairy products, restaurant bills, etc."));
        expenseDb_helper.categories_dao().insertExpenseCategories(new ExpenseCategories(
                "Shopping", "Apparels shopping, Appliances shopping, etc."));

        List<ExpenseCategories> categoriesList = expenseDb_helper.categories_dao().getAllCategories();
        Log.d("database", "performed insertion");

        CategoriesAdapter adapter = new CategoriesAdapter(categoriesList);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        categoryRecycler.setAdapter(adapter);
    }
}
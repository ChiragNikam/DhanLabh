package com.example.dhanlabh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.dhanlabh.a_Entities.ExpenseCategories;
import com.example.dhanlabh.a_Entities.ExpenseEntries;
import com.example.dhanlabh.c_Database.ExpenseDb_helper;
import java.util.ArrayList;
import java.util.List;

public class Activity4_YourSpendings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_your_spendings);

        // adding and setting toolbar
        Toolbar toolbar4 = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar4);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);  // back button on toolbar
        }

        ExpenseDb_helper categories = ExpenseDb_helper.getDb(this);
        List<ExpenseEntries> entries = categories.expenseEntries_dao().getAllEntries();
        List<ExpenseCategories> category_types = categories.categories_dao().getAllCategories();
        List<CategoryWiseDestribution> dist_categories = new ArrayList<>();
        for(ExpenseCategories cat_type : category_types){
            CategoryWiseDestribution dist_cat = new CategoryWiseDestribution(cat_type.getCategory_name(),
                                                    getAmountByCategories(entries, cat_type.getCategory_name()));
            dist_categories.add(dist_cat);
        }
        for(int i = 0; i < dist_categories.size(); i++){
            CategoryWiseDestribution categoryDestri = dist_categories.get(i);
            if(categoryDestri.getAmount() == 0.0){
                dist_categories.remove(i);
            }
        }
        RecyclerView recyclerCategory = findViewById(R.id.recyclerCategoriesDist);
        Adapter_CategoriesDestri categoriesDestri = new Adapter_CategoriesDestri(dist_categories);
        recyclerCategory.setLayoutManager(new LinearLayoutManager(this));
        recyclerCategory.setAdapter(categoriesDestri);
    }

    // Function to get Amount spent by Categories
    private double getAmountByCategories(List<ExpenseEntries> entries, String category) {
        List<Double> amount = new ArrayList<>();
        for (ExpenseEntries cat : entries) {
            if (cat.exp_type.equalsIgnoreCase(category)) {
                amount.add(cat.exp_amount);
            }
        }
        return getSum(amount);
    }

    private double getSum(List<Double> lst) {
        double sum_amount = 0;
        for (double amount : lst) {
            sum_amount = sum_amount + amount;
        }
        return sum_amount;
    }
}


package com.example.dhanlabh.Data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dhanlabh.Model.DbCategoriesHandler;
import com.example.dhanlabh.Parameters.DbParameters;

import java.util.ArrayList;
import java.util.List;

public class CategoryDbHandler extends SQLiteOpenHelper{
    public CategoryDbHandler(Context context){
        super(context, DbParameters.DB_NAME, null, DbParameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table_category = "CREATE TABLE " + DbParameters.TAB_CATEGORY +
                            " ( " + DbParameters.CATEGORY_COL_EXP_CATEGORIES + " TEXT PRIMARY KEY, " + DbParameters.CATEGORY_COL_CATEGORY_DESCRIPTION +" TEXT) ";
        Log.d("create_table", "Category table created: " + create_table_category);
        db.execSQL(create_table_category);
        addCategories("Others", "Miscellaneous expenses");
        addCategories("Food and Dining", "Groceries, dairy products, restaurant bills, etc.");
        addCategories("Shopping", "Apparels shopping, Appliances shopping, etc.");
        addCategories("Travelling", "Bus tickets, Train tickets, fuel bills, etc.");
        addCategories("Entertainment", "Movie tickets, amusement park rides, etc.");
        addCategories("Investments", "Stocks, bonds, mutual funds, etc.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // INSERT Query
    public void addCategories(String category, String desc_category){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbParameters.CATEGORY_COL_EXP_CATEGORIES, category);   // Storing category string in value object
        values.put(DbParameters.CATEGORY_COL_CATEGORY_DESCRIPTION, desc_category);

        db.insert(DbParameters.TAB_CATEGORY, null, values); // Adding category to the table using values obj
        db.close();
    }

    // SELECT Query
    public List<DbCategoriesHandler> getAllCategories(){
        List<DbCategoriesHandler> categories = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        String select_query = "SELECT * FROM " + DbParameters.TAB_CATEGORY;

        Cursor cursor = db.rawQuery(select_query, null);

        if(cursor.moveToFirst()){
            do {
                // getting category with its description and setting categories and there description to the object of DbCategoriesHandler.
                DbCategoriesHandler set_categories = new DbCategoriesHandler(cursor.getString(0), cursor.getString(1));
                Log.d("select","category: " + set_categories.getCategory() + ", description: " + set_categories.getDesc_category());
                // Adding above object to the categories list.
                categories.add(set_categories);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return categories;
    }
}
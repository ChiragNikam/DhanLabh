package com.example.dhanlabh.c_Database;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.dhanlabh.Parameters.DbParameters;
import com.example.dhanlabh.a_Entities.ExpenseCategories;
import com.example.dhanlabh.a_Entities.ExpenseEntries;
import com.example.dhanlabh.b_DataAcessObject.Categories_DAO;
import com.example.dhanlabh.b_DataAcessObject.ExpenseEntries_DAO;

@Database(entities = {ExpenseEntries.class, ExpenseCategories.class}, version = DbParameters.DB_VERSION)
public abstract class ExpenseDb_helper extends RoomDatabase {
    private static final String PREF_NAME = "com.example.dhanlabh.EXPENSE_PREFS";
    private static final String KEY_CATEGORIES_INSERTED = "CATEGORIES_INSERTED";
    private static ExpenseDb_helper instance;

    public static synchronized ExpenseDb_helper getDb(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, ExpenseDb_helper.class, DbParameters.DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                          .build();
        }
        return instance;
    }

    RoomDatabase.Callback rdc = new RoomDatabase.Callback() {
        public void onCreate (SupportSQLiteDatabase db) {
            categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Others", "Miscellaneous expenses"));
            categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Food and Dining", "Groceries, dairy products, restaurant bills, etc."));
            categories_dao().insertExpenseCategories(new ExpenseCategories(
                    "Shopping", "Apparels shopping, Appliances shopping, etc."));
        }
        public void onOpen (SupportSQLiteDatabase db) {
            // do something every time database is open
        }
    };

    public static boolean areCategoriesInserted(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_CATEGORIES_INSERTED, false);
    }

    public static void setCategoriesInserted(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_CATEGORIES_INSERTED, true).apply();
    }

    public abstract ExpenseEntries_DAO expenseEntries_dao();

    public abstract Categories_DAO categories_dao();
}

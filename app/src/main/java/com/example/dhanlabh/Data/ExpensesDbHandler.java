/*
    Data Package: This data package will have class which will perform operations over data or table in database,
          operations like creating a table, inserting or deleting data from table, and updating data of table.
*/
package com.example.dhanlabh.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dhanlabh.Model.DbEntriesHandler;
import com.example.dhanlabh.Parameters.DbParameters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpensesDbHandler extends SQLiteOpenHelper {
    public ExpensesDbHandler(Context context){
        super(context, DbParameters.DB_NAME, null, DbParameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    // CREATE Operation
        String create_table= "CREATE TABLE " + DbParameters.TAB_EXP_RECORDS + "( " +
                DbParameters.COL_ID + " INTEGER PRIMARY KEY, " +
                DbParameters.COL_EXP_TYPE + " TEXT, " + DbParameters.COL_EXP_AMOUNT + " INTEGER, "
                + DbParameters.COL_EXP_DATE+" TEXT )";
        Log.d("createTable", "table is created successfully " + create_table);
        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // INSERT Operation
    public void addEntry(DbEntriesHandler exp){
        SQLiteDatabase db = this.getWritableDatabase(); // getting a writable database to perform operations

        ContentValues content = new ContentValues();
        content.put(DbParameters.COL_EXP_TYPE, exp.getExp_type());
        content.put(DbParameters.COL_EXP_AMOUNT, exp.getExp_amount());
        content.put(DbParameters.COL_EXP_DATE, exp.getExp_date());

        db.insert(DbParameters.TAB_EXP_RECORDS, null, content);    // inserting data to table
        db.close();
    }

    // READ Operation
    public List<DbEntriesHandler> getAllEntries(){
        List<DbEntriesHandler> expense_table = new ArrayList<>(); // creating a list to store data of a table in it

        SQLiteDatabase db = this.getReadableDatabase();

        String select_query = "SELECT * FROM " + DbParameters.TAB_EXP_RECORDS;
        Cursor cursor = db.rawQuery(select_query, null);

        if(cursor.moveToFirst()){
            do{
                DbEntriesHandler expense_entries = new DbEntriesHandler();   // creating an object of ExpenseEntries class to get data of table to it

                // setting different column of rows in a table to object
                expense_entries.setId(Integer.parseInt(cursor.getString(0)));
                expense_entries.setExp_type(cursor.getString(1));
                expense_entries.setExp_amount(Double.parseDouble(cursor.getString(2)));
                expense_entries.setExp_date(cursor.getString(3));

                // getting data of the table into an object and storing it into an arraylist of object type
                expense_table.add(expense_entries);
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        Collections.reverse(expense_table); // to reverse list, so that the latest added entry should get at top of the recycler view

        return expense_table;
    }

    // UPDATE Query
    public void updateEntries(DbEntriesHandler exp){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbParameters.COL_EXP_TYPE, exp.getExp_type());
        values.put(DbParameters.COL_EXP_AMOUNT, exp.getExp_amount());
        values.put(DbParameters.COL_EXP_DATE, exp.getExp_date());
        Log.d("update_data", "Updating entries: id: " + exp.getId() + ", amount: " + exp.getExp_amount());
        // updating here
        db.update(DbParameters.TAB_EXP_RECORDS, values, DbParameters.COL_ID + "=?",
                new String[]{String.valueOf(exp.getId())});   // this function will return no of affected rows in table
    }

    // DELETE Query
    public void deleteEntries(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String col_id = DbParameters.COL_ID;
        int affected_rows = db.delete(DbParameters.TAB_EXP_RECORDS, col_id + "=?", new String[]{String.valueOf(id)});
        Log.d("delete_data", ""+affected_rows);
        db.close();
    }
}

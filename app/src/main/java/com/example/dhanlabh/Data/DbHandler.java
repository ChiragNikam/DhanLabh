/*
    Data Package: This data package will have class which will perform operations over data or table in database,
          operations like creating a table, inserting or deleting data from table, and updating data of table.
*/
package com.example.dhanlabh.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dhanlabh.Parameters.DbParameters;

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(Context context){
        super(context, DbParameters.DB_NAME, null, DbParameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table= "CREATE TABLE " + DbParameters.TAB_NAME + "( " +
                DbParameters.COL_ID + " INTEGER PRIMARY KEY, " +
                DbParameters.COL_EXP_TYPE + " TEXT, " + DbParameters.COL_EXP_AMOUNT + " INTEGER, "
                + DbParameters.COL_EXP_DATE+" TEXT )";
        Log.d("createTable", "table is created successfully " + create_table);
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

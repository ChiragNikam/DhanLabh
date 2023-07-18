package com.example.dhanlabh.b_DataAcessObject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dhanlabh.Parameters.DbParameters;
import com.example.dhanlabh.a_Entities.ExpenseEntries;

import java.util.List;

@Dao
public interface ExpenseEntries_DAO {
    @Query("SELECT * FROM " + DbParameters.TAB_EXP_RECORDS)
    List<ExpenseEntries> getAllEntries();

    @Insert
    void insertExpenseEntries(ExpenseEntries insert_entries);

    @Update
    void updateExpenseEntries(ExpenseEntries update_entries);

    @Delete
    void deleteExpenseEntries(ExpenseEntries delete_entries);
}

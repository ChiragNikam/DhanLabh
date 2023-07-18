package com.example.dhanlabh.b_DataAcessObject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dhanlabh.Parameters.DbParameters;
import com.example.dhanlabh.a_Entities.ExpenseCategories;
import com.example.dhanlabh.a_Entities.ExpenseEntries;

import java.util.List;

@Dao
public interface Categories_DAO {
    @Query("SELECT * FROM " + DbParameters.TAB_CATEGORY)
    List<ExpenseCategories> getAllCategories();

    @Insert
    void insertExpenseCategories(ExpenseCategories insert_category);

    @Update
    void updateExpenseCategories(ExpenseCategories update_category);

    @Delete
    void deleteExpenseCategories(ExpenseCategories delete_category);
}

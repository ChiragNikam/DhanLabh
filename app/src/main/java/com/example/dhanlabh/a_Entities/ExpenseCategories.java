package com.example.dhanlabh.a_Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.dhanlabh.Parameters.DbParameters;

@Entity(tableName = DbParameters.TAB_CATEGORY)
public class ExpenseCategories {
    @PrimaryKey(autoGenerate = true)
    int category_id;
    @ColumnInfo(name = DbParameters.CATEGORY_COL_CATEGORIES_NAME)
    String category_name;
    @ColumnInfo(name = DbParameters.CATEGORY_COL_CATEGORY_DESCRIPTION)
    String category_description;

    public ExpenseCategories(int category_id, String category_name, String category_description) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
    }
    @Ignore
    public ExpenseCategories(String category_name, String category_description) {
        this.category_name = category_name;
        this.category_description = category_description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
}

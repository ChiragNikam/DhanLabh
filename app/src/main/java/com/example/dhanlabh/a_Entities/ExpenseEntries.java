package com.example.dhanlabh.a_Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.dhanlabh.Parameters.DbParameters;

@Entity(tableName = DbParameters.TAB_EXP_RECORDS)
public class ExpenseEntries {
    // Columns of table
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = DbParameters.COL_EXP_TYPE)
    public String exp_type;
    @ColumnInfo(name = DbParameters.COL_EXP_AMOUNT)
    public double exp_amount;
    @ColumnInfo(name = DbParameters.COL_EXP_DATE)
    public String exp_date;

    public ExpenseEntries(int id, String exp_type, double exp_amount, String exp_date){
        this.id = id;
        this.exp_amount = exp_amount;
        this.exp_type = exp_type;
        this.exp_date = exp_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExp_type() {
        return exp_type;
    }

    public void setExp_type(String exp_type) {
        this.exp_type = exp_type;
    }

    public double getExp_amount() {
        return exp_amount;
    }

    public void setExp_amount(double exp_amount) {
        this.exp_amount = exp_amount;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    @Ignore
    public ExpenseEntries(String exp_type, double exp_amount, String exp_date){
        this.exp_amount = exp_amount;
        this.exp_type = exp_type;
        this.exp_date = exp_date;
    }
}

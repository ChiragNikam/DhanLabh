/*
* Model Package: This package have class which will help to insert data into table, 
*               firstly by storing it into local variable of class and then insert it using
*               SQL query.
*/
package com.example.dhanlabh.Model;

public class DbEntriesHandler {
    private int id;
    private String exp_type;
    private int exp_amount;

    public DbEntriesHandler(String exp_type, int exp_amount) {
        this.exp_type = exp_type;
        this.exp_amount = exp_amount;
    }

    public DbEntriesHandler(int id, String exp_type, int exp_amount) {
        this.id = id;
        this.exp_type = exp_type;
        this.exp_amount = exp_amount;
    }

    public DbEntriesHandler(){}

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

    public int getExp_amount() {
        return exp_amount;
    }

    public void setExp_amount(int exp_amount) {
        this.exp_amount = exp_amount;
    }
}

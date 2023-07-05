/*
* Model Package: This package have class which will help to insert data into table, 
*               firstly by storing it into local variable of class and then insert it using
*               SQL query.
*/
package com.example.dhanlabh.Model;

public class DbEntriesHandler {
    private int id;
    private String exp_type;
    private double exp_amount;
    private String exp_date;

    public DbEntriesHandler(String exp_type, int exp_amount, String exp_date) {
        this.exp_type = exp_type;
        this.exp_amount = exp_amount;
        this.exp_date = exp_date;
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

    public double getExp_amount() {
        return exp_amount;
    }

    public void setExp_amount(double exp_amount) {
        this.exp_amount = exp_amount;
    }

    public String getExp_date() { return exp_date; }

    public void setExp_date(String exp_date) { this.exp_date = exp_date; }
}

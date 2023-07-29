package com.example.dhanlabh;

public class CategoryWiseDestribution {
    private String category;
    private double amount;

    public CategoryWiseDestribution(String category, double amount){
        this.category = category;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

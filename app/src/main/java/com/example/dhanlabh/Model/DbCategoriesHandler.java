package com.example.dhanlabh.Model;

public class DbCategoriesHandler {
    private String category;
    private String desc_category;

    public DbCategoriesHandler(String category, String desc_category) {
        this.category = category;
        this.desc_category = desc_category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc_category() {
        return desc_category;
    }

    public void setDesc_category(String desc_category) {
        this.desc_category = desc_category;
    }
}

/*
* Parameters Package: This package will have all the parameters related to database, like database_name,
                      database_version, table_name, column_names, etc;
*/
package com.example.dhanlabh.Parameters;

public class DbParameters {
    public static final int DB_VERSION = 2;
    public static final String DB_NAME = "Expense_Management";
    public static final String TAB_EXP_RECORDS = "expense_records";
    public static final String TAB_CATEGORY = "expense_category";

    // Columns and Keys of Table - expense_records
    public static final String COL_ID = "id";   // primary key of table
    public static final String COL_EXP_TYPE = "exp_type";
    public static final String COL_EXP_AMOUNT = "exp_amount";
    public static final String COL_EXP_DATE = "exp_date";

    // Columns and Keys of Table - expense_category;
    public static final String CATEGORY_COL_ID = "category_id";
    public static final String CATEGORY_COL_EXP_CATEGORIES = "exp_category";
    public static final String CATEGORY_COL_CATEGORY_DESCRIPTION = "category_description";
}

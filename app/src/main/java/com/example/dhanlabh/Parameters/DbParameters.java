/*
* Parameters Package: This package will have all the parameters related to database, like database_name,
                      database_version, table_name, column_names, etc;
*/
package com.example.dhanlabh.Parameters;

public class DbParameters {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Expense_Management";
    public static final String TAB_NAME = "expense_records";

    // Columns and Keys of Table
    public static final String COL_ID = "id";   // primary key of table
    public static final String COL_EXP_TYPE = "exp_type";
    public static final String COL_EXP_AMOUNT = "exp_amount";
    public static final String COL_EXP_DATE = "exp_date";
}

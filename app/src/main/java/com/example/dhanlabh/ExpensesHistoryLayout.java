package com.example.dhanlabh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ExpensesHistoryLayout extends ArrayAdapter<String> {
    public ArrayList<String> category;
    public ArrayList<Integer> amount;
    public ExpensesHistoryLayout(@NonNull Context context, int resource, @NonNull ArrayList<String> category, @NonNull ArrayList<Integer> amount){
        super(context, resource, category);
        this.category = category;
        this.amount = amount;
    }
    @Nullable
    public String getCategory(int position){
        return category.get(position);
    }
    public int getAmount(int position){
        return amount.get(position);
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_expenses_history, parent, false);
        TextView txt_category = convertView.findViewById(R.id.txtCategory);
        TextView txt_amount = convertView.findViewById(R.id.txtAmount);
        String for_amount = txt_amount.getText().toString() + getAmount(position);
        txt_amount.setText(for_amount);
        String for_category = txt_category.getText().toString() + getCategory(position);
        txt_category.setText(for_category);
        return convertView;
    }
}

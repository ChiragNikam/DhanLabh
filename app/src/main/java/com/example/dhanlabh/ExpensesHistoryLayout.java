package com.example.dhanlabh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class ExpensesHistoryLayout extends ArrayAdapter<String> {
    public String category;
    public int amount;
    public ExpensesHistoryLayout(@NonNull Context context, int resource, @NonNull String category, @NonNull int amount){
        super(context, resource, Collections.singletonList(category));
        this.category = category;
        this.amount = amount;
    }
    @Nullable
    public String getCategory(int position){
        return category;
    }
    public int getAmount(int position){
        return amount;
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.expenses_history_layout, parent, false);
        TextView txt = convertView.findViewById(R.id.txtCategory);
        TextView txt1 = convertView.findViewById(R.id.txtAmount);
        txt1.setText(txt1.getText().toString() + getAmount(position));
        txt.setText(txt.getText().toString() + getCategory(position));
        return convertView;
    }
}

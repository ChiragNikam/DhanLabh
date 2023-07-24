package com.example.dhanlabh;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhanlabh.a_Entities.ExpenseCategories;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    List<ExpenseCategories> categoryList;
    String saved_amount;
    public CategoriesAdapter(List<ExpenseCategories> categoryList, String saved_amount){
        this.categoryList = categoryList;
        this.saved_amount = saved_amount;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExpenseCategories categories = categoryList.get(position);
        holder.txt_categoryName.setText(categories.getCategory_name());
        holder.txt_categoryDesc.setText(categories.getCategory_description());

        holder.view_category.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Activity2_1_Input_Expense_Entries.class);
            intent.putExtra("to-do", "category");
            intent.putExtra("category_name", categories.getCategory_name());
            intent.putExtra("saved_amount", saved_amount);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_categoryName;
        public TextView txt_categoryDesc;
        public LinearLayoutCompat view_category;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_categoryName = itemView.findViewById(R.id.txt_categoryName);
            txt_categoryDesc = itemView.findViewById(R.id.txt_categoryDesc);
            view_category = itemView.findViewById(R.id.categoriesView);
        }
    }
}

package com.example.dhanlabh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhanlabh.a_Entities.ExpenseCategories;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    List<ExpenseCategories> categoryList;
    public CategoriesAdapter(List<ExpenseCategories> categoryList){
        this.categoryList = categoryList;
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
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_categoryName;
        public TextView txt_categoryDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_categoryName = itemView.findViewById(R.id.txt_categoryName);
            txt_categoryDesc = itemView.findViewById(R.id.txt_categoryDesc);
//            txtAmount = itemView.findViewById(R.id.txtAmount);
//            txtCategory = itemView.findViewById(R.id.txtCategory);
//            txtDate = itemView.findViewById(R.id.txtDate);
//            img_edit = itemView.findViewById(R.id.btn_edit);
//            img_delete = itemView.findViewById(R.id.btn_delete);
        }
    }
}

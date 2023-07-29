package com.example.dhanlabh;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter_CategoriesDestri extends RecyclerView.Adapter<Adapter_CategoriesDestri.ViewHolder> {
    private final List<CategoryWiseDestribution> categoryWiseDestributionList;
    public Adapter_CategoriesDestri(List<CategoryWiseDestribution> categoryWiseDestributionList){
        this.categoryWiseDestributionList = categoryWiseDestributionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_categories_destri, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryWiseDestribution category = categoryWiseDestributionList.get(position);

        if(category.getAmount() > 0.0) {
            holder.txt_categoryName.setText(category.getCategory());
            String amount = "₹" + category.getAmount();
            holder.txt_totalCategoryAmount.setGravity(Gravity.END);
            holder.txt_totalCategoryAmount.setText(amount);
        }
    }

    @Override
    public int getItemCount() {
        return categoryWiseDestributionList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_categoryName;
        public TextView txt_totalCategoryAmount;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_categoryName = itemView.findViewById(R.id.txt_category_dest);
            txt_totalCategoryAmount = itemView.findViewById(R.id.txt_total_amount);
        }
    }
}

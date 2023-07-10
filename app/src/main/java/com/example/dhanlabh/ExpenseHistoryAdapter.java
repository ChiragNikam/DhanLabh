package com.example.dhanlabh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhanlabh.Model.DbEntriesHandler;

import java.util.List;

public class ExpenseHistoryAdapter extends RecyclerView.Adapter<ExpenseHistoryAdapter.ViewHolder> {
    private final List<DbEntriesHandler> entriesList;

    public ExpenseHistoryAdapter(List<DbEntriesHandler> entriesList) {
        this.entriesList = entriesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_expenses_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DbEntriesHandler entry = entriesList.get(position);

        // Set the expense amount
        String amount_to_set = "\u20B9" + entry.getExp_amount();
        holder.txtAmount.setText(amount_to_set);

        // Set the expense category
        holder.txtCategory.setText(entry.getExp_type());
    }

    @Override
    public int getItemCount() {
        return entriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAmount;
        public TextView txtCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            txtCategory = itemView.findViewById(R.id.txtCategory);
        }
    }
}

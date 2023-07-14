package com.example.dhanlabh;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        // Set expense amount
        String amount_to_set = "\u20B9" + entry.getExp_amount();
        holder.txtAmount.setText(amount_to_set);

        // Set expense category
        holder.txtCategory.setText(entry.getExp_type());

        //Set expense date
        holder.txtDate.setText(entry.getExp_date());


        holder.img_edit.setOnClickListener(view -> {
            // Get the clicked entry
            DbEntriesHandler clickedEntry = entriesList.get(position);

            // Start Activity2_1_Input_Expense_Entries and pass the clicked entry
            Intent intent = new Intent(view.getContext(), Activity2_1_Input_Expense_Entries.class);
            intent.putExtra("to-do", "update");
            intent.putExtra("id", clickedEntry.getId());
            intent.putExtra("amount", clickedEntry.getExp_amount());
            intent.putExtra("type", clickedEntry.getExp_type());
            intent.putExtra("date", clickedEntry.getExp_date());
            view.getContext().startActivity(intent);
        });
        holder.img_delete.setOnClickListener(view -> {
            DbEntriesHandler clickedEntry = entriesList.get(position);


        });
    }

    @Override
    public int getItemCount() {
        return entriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAmount;
        public TextView txtCategory;
        public TextView txtDate;
        public ImageView img_edit;
        public ImageView img_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            txtDate = itemView.findViewById(R.id.txtDate);
            img_edit = itemView.findViewById(R.id.btn_edit);
            img_delete = itemView.findViewById(R.id.btn_delete);
        }
    }


}
package com.zo0okadev.bmtask.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zo0okadev.bmtask.databinding.ItemBreakdownBinding;
import com.zo0okadev.bmtask.model.IngredientDetails;
import com.zo0okadev.bmtask.ui.viewHolders.BreakDownViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 07 Jul, 2021.
 * Have a nice day!
 */
public class BreakDownAdapter extends RecyclerView.Adapter<BreakDownViewHolder> {
    private List<IngredientDetails> ingredientDetails;

    @NonNull
    @Override
    public BreakDownViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new BreakDownViewHolder(ItemBreakdownBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BreakDownViewHolder holder, int position) {
        holder.bindTo(ingredientDetails.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredientDetails != null ? ingredientDetails.size() : 0;
    }

    public void setIngredientDetails(List<IngredientDetails> ingredientDetails) {
        this.ingredientDetails = ingredientDetails;
        notifyDataSetChanged();
    }
}

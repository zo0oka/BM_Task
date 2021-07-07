package com.zo0okadev.bmtask.ui.viewHolders;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zo0okadev.bmtask.databinding.ItemBreakdownBinding;
import com.zo0okadev.bmtask.model.IngredientDetails;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 07 Jul, 2021.
 * Have a nice day!
 */
public class BreakDownViewHolder extends RecyclerView.ViewHolder {
    private ItemBreakdownBinding binding;

    public BreakDownViewHolder(@NonNull ItemBreakdownBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindTo(IngredientDetails ingredientDetails) {
        binding.setIngredient(ingredientDetails);
    }
}

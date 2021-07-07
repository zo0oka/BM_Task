package com.zo0okadev.bmtask.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.zo0okadev.bmtask.data.NetworkRepo;
import com.zo0okadev.bmtask.model.IngredientDetails;
import com.zo0okadev.bmtask.model.IngredientDetailsRequest;

import java.util.List;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 07 Jul, 2021.
 * Have a nice day!
 */
public class TotalNutritionViewModel extends ViewModel {
    private final NetworkRepo repo;

    public TotalNutritionViewModel() {
        this.repo = new NetworkRepo();
    }

    public LiveData<IngredientDetails> getIngredientsDetails(List<String> ingredients) {
        return repo.getIngredientsDetails(new IngredientDetailsRequest(ingredients));
    }
}

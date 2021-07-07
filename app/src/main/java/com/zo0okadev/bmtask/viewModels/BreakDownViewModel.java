package com.zo0okadev.bmtask.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.zo0okadev.bmtask.data.NetworkRepo;
import com.zo0okadev.bmtask.model.IngredientDetails;

import java.util.List;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public class BreakDownViewModel extends ViewModel {
    private NetworkRepo repo;
    private final LiveData<List<IngredientDetails>> ingredientDetails;

    public BreakDownViewModel() {
        this.repo = new NetworkRepo();
        ingredientDetails = repo.getIngredientData();
    }

    public void requestIngredientData(List<String> ingredients) {
        repo.requestIngredientData(ingredients);
    }

    public LiveData<List<IngredientDetails>> getIngredientData() {
        return ingredientDetails;
    }


}

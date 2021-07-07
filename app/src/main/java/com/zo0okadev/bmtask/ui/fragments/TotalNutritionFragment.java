package com.zo0okadev.bmtask.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.zo0okadev.bmtask.databinding.FragmentTotalNutritionBinding;
import com.zo0okadev.bmtask.model.IngredientDetails;
import com.zo0okadev.bmtask.viewModels.TotalNutritionViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import timber.log.Timber;

public class TotalNutritionFragment extends Fragment {
    private FragmentTotalNutritionBinding binding;
    private String[] receivedIngredients;

    public TotalNutritionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        receivedIngredients = TotalNutritionFragmentArgs.fromBundle(getArguments()).getTotalNutritionIngredients();
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTotalNutritionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setLoading(true);
        TotalNutritionViewModel totalNutritionViewModel = new ViewModelProvider(this).get(TotalNutritionViewModel.class);
        totalNutritionViewModel.getIngredientsDetails(Arrays.asList(receivedIngredients)).observe(getViewLifecycleOwner(), ingredientDetails -> {
            Timber.e(new Gson().toJson(ingredientDetails));
            binding.setIngredientsData(ingredientDetails);
            binding.totalCarbs.setText(String.format("%s%%", IngredientDetails.getTotalCarbs(ingredientDetails)));
            binding.totalVitamins.setText(String.format("%s%%", IngredientDetails.getTotalVitamins(ingredientDetails)));
            binding.setLoading(false);
        });
    }
}
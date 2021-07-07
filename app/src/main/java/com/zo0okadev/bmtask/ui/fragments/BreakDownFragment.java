package com.zo0okadev.bmtask.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.zo0okadev.bmtask.databinding.FragmentBreakDownBinding;
import com.zo0okadev.bmtask.interfaces.ClickHandlers;
import com.zo0okadev.bmtask.ui.adapters.BreakDownAdapter;
import com.zo0okadev.bmtask.viewModels.BreakDownViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import timber.log.Timber;

public class BreakDownFragment extends Fragment implements ClickHandlers.BreakDownHandler {
    private FragmentBreakDownBinding binding;
    private List<String> ingredients;
    private BreakDownViewModel breakDownViewModel;
    private String[] receivedIngredients;

    public BreakDownFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        breakDownViewModel = new ViewModelProvider(this).get(BreakDownViewModel.class);
        receivedIngredients = BreakDownFragmentArgs.fromBundle(getArguments()).getBreakDownNutritionIngredients();
        Timber.e("Received Items: " + receivedIngredients.length);
        ingredients = Arrays.asList(receivedIngredients);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBreakDownBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setHandler(this);
        binding.setLoading(true);

        breakDownViewModel.requestIngredientData(ingredients);

        BreakDownAdapter adapter = new BreakDownAdapter();
        binding.breakDownRecyclerView.setAdapter(adapter);

        breakDownViewModel.getIngredientData().observe(getViewLifecycleOwner(), details -> {
            adapter.setIngredientDetails(details);
            binding.setLoading(false);
        });
    }

    @Override
    public void onNutritionFacts() {
        Navigation.findNavController(requireView())
                .navigate(BreakDownFragmentDirections.actionBreakDownFragmentToTotalNutritionFragment(receivedIngredients));
    }
}
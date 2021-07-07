package com.zo0okadev.bmtask.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.gson.Gson;
import com.zo0okadev.bmtask.databinding.FragmentAddIngredientsBinding;
import com.zo0okadev.bmtask.interfaces.ClickHandlers;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

public class AddIngredientsFragment extends Fragment implements ClickHandlers.AddIngredientsHandler, TextWatcher {
    private FragmentAddIngredientsBinding binding;
    private String[] lines;

    public AddIngredientsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddIngredientsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setHandler(this);
        binding.textInputField.addTextChangedListener(this);
    }

    @Override
    public void onAnalyse() {
        Timber.e("Lines: %s", new Gson().toJson(lines));
        Navigation.findNavController(requireView())
                .navigate(AddIngredientsFragmentDirections.actionAddIngredientsFragmentToBreakDownFragment(lines));
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        binding.setEnableButton(editable.length() > 0);
        lines = editable.toString().split("\n");
    }
}
package com.zo0okadev.bmtask.interfaces;

import com.zo0okadev.bmtask.model.IngredientDetails;

import java.util.List;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public interface IngredientDetailsListener {
    void onLoaded(List<IngredientDetails> details);
}

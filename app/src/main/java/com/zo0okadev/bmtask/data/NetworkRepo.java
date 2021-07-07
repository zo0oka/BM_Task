package com.zo0okadev.bmtask.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zo0okadev.bmtask.helpers.Constants;
import com.zo0okadev.bmtask.interfaces.IngredientDetailsListener;
import com.zo0okadev.bmtask.model.IngredientDetails;
import com.zo0okadev.bmtask.model.IngredientDetailsRequest;
import com.zo0okadev.bmtask.remote.ApiClient;
import com.zo0okadev.bmtask.remote.ApiService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public class NetworkRepo implements IngredientDetailsListener {
    private final ApiService service;
    private final MutableLiveData<List<IngredientDetails>> detailsMutableLiveData;


    public NetworkRepo() {
        this.service = ApiClient.getInstance();
        detailsMutableLiveData = new MutableLiveData<>();
    }

    public void requestIngredientData(List<String> ingredients) {
        ApiClient.requestIngredientData(service, ingredients, this);
    }

    public LiveData<List<IngredientDetails>> getIngredientData() {
        return detailsMutableLiveData;
    }

    @Override
    public void onLoaded(List<IngredientDetails> details) {
        Timber.e("Loaded Details: %s", details.size());
        detailsMutableLiveData.postValue(details);
    }

    public LiveData<IngredientDetails> getIngredientsDetails(IngredientDetailsRequest request) {
        MutableLiveData<IngredientDetails> ingredientDetails = new MutableLiveData<>();
        service.getIngredientsDetails(Constants.APP_ID, Constants.APP_KEY, request).enqueue(new Callback<IngredientDetails>() {
            @Override
            public void onResponse(@NotNull Call<IngredientDetails> call, @NotNull Response<IngredientDetails> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ingredientDetails.postValue(response.body());
                    }
                } else {
                    try {
                        if (response.errorBody() != null) {
                            Timber.e("Ingredients Details Error %s", response.errorBody().string());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<IngredientDetails> call, @NotNull Throwable t) {
                Timber.e("Ingredients Details Failure %s", t.getMessage());
            }
        });
        return ingredientDetails;
    }
}

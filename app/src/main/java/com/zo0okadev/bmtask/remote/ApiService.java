package com.zo0okadev.bmtask.remote;

import com.zo0okadev.bmtask.model.IngredientDetails;
import com.zo0okadev.bmtask.model.IngredientDetailsRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public interface ApiService {
    @GET("api/nutrition-data")
    Call<IngredientDetails> getIngredientData(@Query("app_id") String appId,
                                              @Query("app_key") String appKey,
                                              @Query("ingr") String ingredient);

    @POST("api/nutrition-details")
    Call<IngredientDetails> getIngredientsDetails(@Query("app_id") String appId,
                                                  @Query("app_key") String appKey,
                                                  @Body IngredientDetailsRequest request);
}

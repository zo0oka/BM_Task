package com.zo0okadev.bmtask.remote;

import com.zo0okadev.bmtask.helpers.Constants;
import com.zo0okadev.bmtask.interfaces.IngredientDetailsListener;
import com.zo0okadev.bmtask.model.IngredientDetails;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public class ApiClient {
    private static final String BASE_URL = "https://api.edamam.com/";
    private static ApiService instance = null;


    public static ApiService getInstance() {

        if (instance == null) {

            // For logging
            HttpLoggingInterceptor loggingInterceptor =
                    new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            // Building OkHttp client
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.@NotNull Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
                            Request original = chain.request();
                            Request request = original.newBuilder()
                                    .header("Accept", "application/json")
                                    .header("Content-Type", "application/json")
                                    .method(original.method(), original.body())
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .callTimeout(0, TimeUnit.MILLISECONDS)
                    .readTimeout(0, TimeUnit.MILLISECONDS)
                    .writeTimeout(0, TimeUnit.MILLISECONDS)
                    .connectTimeout(0, TimeUnit.MILLISECONDS)
                    .build();

            // Retrofit Builder
            Retrofit.Builder builder =
                    new Retrofit
                            .Builder()
                            .baseUrl(BASE_URL)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create());

            instance = builder.build().create(ApiService.class);
        }
        return instance;
    }

    public static void requestIngredientData(ApiService service, List<String> ingredients, IngredientDetailsListener listener) {
        List<IngredientDetails> details = new ArrayList<>();
        for (int i = 0; i < ingredients.size(); i++) {
            String ingredient = ingredients.get(i);
            if (i == (ingredients.size() - 1)) {
                service.getIngredientData(Constants.APP_ID, Constants.APP_KEY, ingredient).enqueue(new Callback<IngredientDetails>() {
                    @Override
                    public void onResponse(@NotNull Call<IngredientDetails> call, @NotNull Response<IngredientDetails> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                IngredientDetails ingredientDetails = response.body();
                                ingredientDetails.setFoodName(ingredient);
                                details.add(ingredientDetails);
                                listener.onLoaded(details);
                            }
                        } else {
                            try {
                                if (response.errorBody() != null) {
                                    Timber.e("Ingredient Details Error: %s", response.errorBody().string());
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<IngredientDetails> call, @NotNull Throwable t) {
                        Timber.e("Ingredient Details Failure: %s", t.getMessage());
                    }
                });
            } else {
                service.getIngredientData(Constants.APP_ID, Constants.APP_KEY, ingredient).enqueue(new Callback<IngredientDetails>() {
                    @Override
                    public void onResponse(@NotNull Call<IngredientDetails> call, @NotNull Response<IngredientDetails> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                IngredientDetails ingredientDetails = response.body();
                                ingredientDetails.setFoodName(ingredient);
                                details.add(ingredientDetails);
                            }
                        } else {
                            try {
                                if (response.errorBody() != null) {
                                    Timber.e("Ingredient Details Error: %s", response.errorBody().string());
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<IngredientDetails> call, @NotNull Throwable t) {
                        Timber.e("Ingredient Details Failure: %s", t.getMessage());
                    }
                });
            }
        }
    }
}

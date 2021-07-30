package com.example.likingapp.api;

import com.example.likingapp.utils.constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private final MarvelApi marvelApi;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(constants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        marvelApi = retrofit.create(MarvelApi.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public MarvelApi getMyApi() {
        return marvelApi;
    }
}

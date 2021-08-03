package com.example.likingapp.api;

import com.example.likingapp.models.CharacterDataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApi {
    @GET("characters")
    Call<CharacterDataWrapper> getSuperHeroes(
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash,
            @Query("limit") String limit,
            @Query("offset") String offset);
}

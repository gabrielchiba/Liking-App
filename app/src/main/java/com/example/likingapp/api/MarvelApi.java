package com.example.likingapp.api;

import com.example.likingapp.models.CharacterDataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelApi {
    @GET("characters")
    Call<CharacterDataWrapper> getSuperHeroes(
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash);

    @GET("characters")
    Call<CharacterDataWrapper> getSuperHeroesAtLimit(
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash,
            @Query("limit") String limit);

    @GET("characters")
    Call<CharacterDataWrapper> getSuperHeroesAtLimitAtOffset(
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash,
            @Query("limit") String limit,
            @Query("offset") String offset);

    @GET("characters/{characterId}")
    Call<CharacterDataWrapper> getSuperHeroByID(
            @Path("characterId") String characterId,
            @Query("ts") String ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash);
}

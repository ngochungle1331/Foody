package com.app.foody.data.network

import com.app.foody.data.network.response.FoodJoke
import com.app.foody.data.network.response.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("/recipes/complexSearch")
    suspend fun getRecipes(
        @QueryMap queries: Map<String, String>
    ): Response<FoodRecipe>

    @GET("/recipes/complexSearch")
    suspend fun searchRecipes(@QueryMap queries: Map<String, String>): Response<FoodRecipe>

    @GET("food/jokes/random")
    suspend fun getFoodJoke(@Query("apiKey") apiKey: String): Response<FoodJoke>
}
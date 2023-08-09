package com.app.foody.data.source.remote

import com.app.foody.data.network.ApiService
import com.app.foody.data.network.response.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return apiService.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipe> {
        return apiService.searchRecipes(searchQuery)
    }
}
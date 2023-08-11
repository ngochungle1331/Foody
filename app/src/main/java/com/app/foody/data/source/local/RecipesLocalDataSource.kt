package com.app.foody.data.source.local

import com.app.foody.data.network.response.FavoriteEntity
import com.app.foody.data.network.response.FoodJoke
import com.app.foody.data.network.response.FoodJokeEntity
import com.app.foody.data.network.response.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipesLocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
) {
    suspend fun insertRecipes(recipe: Recipe) {
        recipesDao.insertRecipes(recipe)
    }

    fun readRecipes(): Flow<List<Recipe>> {
        return recipesDao.readRecipes()
    }

    fun readFavoriteRecipes(): Flow<List<FavoriteEntity>> {
        return recipesDao.readFavoriteRecipes()
    }

    suspend fun insertFavoriteRecipes(favoriteEntity: FavoriteEntity) {
        recipesDao.insertFavoriteRecipe(favoriteEntity)
    }

    suspend fun deleteFavoriteRecipes(favoriteEntity: FavoriteEntity) {
        recipesDao.deleteFavoriteRecipe(favoriteEntity)
    }

    suspend fun deleteAllFavoriteRecipes() {
        recipesDao.deleteAllFavoriteRecipes()
    }

    fun readFoodJoke(): Flow<List<FoodJokeEntity>> {
        return recipesDao.readFoodJoke()
    }

    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity) {
        recipesDao.insertFoodJoke(foodJokeEntity)
    }
}
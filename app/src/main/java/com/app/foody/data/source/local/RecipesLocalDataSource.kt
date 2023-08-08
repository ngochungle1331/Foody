package com.app.foody.data.source.local

import com.app.foody.data.network.response.Recipe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipesLocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
) {
    suspend fun insertRecipes(recipe: Recipe) {
        recipesDao.insertRecipes(recipe)
    }

    fun readDatabase(): Flow<List<Recipe>> {
        return recipesDao.readRecipes()
    }
}
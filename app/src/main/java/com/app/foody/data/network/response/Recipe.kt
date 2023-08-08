package com.app.foody.data.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.foody.utils.AppConstants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class Recipe(var foodRecipe: FoodRecipe) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}
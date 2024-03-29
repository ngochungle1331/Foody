package com.app.foody.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.app.foody.data.network.response.FavoriteEntity
import com.app.foody.data.network.response.FoodJokeEntity
import com.app.foody.data.network.response.Recipe

@Database(
    entities = [Recipe::class, FavoriteEntity::class, FoodJokeEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase : RoomDatabase() {
    abstract fun recipesDao(): RecipesDao
}
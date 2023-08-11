package com.app.foody.data.network.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.foody.utils.AppConstants.Companion.FOOD_JOKE_TABLE

@Entity(tableName = FOOD_JOKE_TABLE)
class FoodJokeEntity(
    @Embedded
    var foodJoke: FoodJoke
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

}
package com.app.foody.data.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.foody.utils.AppConstants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)
package com.app.foody.data.source

import com.app.foody.data.source.local.RecipesLocalDataSource
import com.app.foody.data.source.remote.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    recipesLocalDataSource: RecipesLocalDataSource
) {
    val remote = remoteDataSource
    val local = recipesLocalDataSource
}
package com.app.foody.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.app.foody.utils.AppConstants
import com.app.foody.utils.AppConstants.Companion.API_KEY
import com.app.foody.utils.AppConstants.Companion.QUERY_ADD_RECIPE_INFORMATION
import com.app.foody.utils.AppConstants.Companion.QUERY_API_KEY
import com.app.foody.utils.AppConstants.Companion.QUERY_DIET
import com.app.foody.utils.AppConstants.Companion.QUERY_FILL_INGREDIENTS
import com.app.foody.utils.AppConstants.Companion.QUERY_NUMBER
import com.app.foody.utils.AppConstants.Companion.QUERY_TYPE

class RecipesViewModel(application: Application) : AndroidViewModel(application) {

    fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        queries[QUERY_NUMBER] = "50"
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = "snack"
        queries[QUERY_DIET] = "primal"
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }

}
package com.app.foody.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.navArgs
import com.app.foody.R
import com.app.foody.data.network.response.FavoriteEntity
import com.app.foody.databinding.ActivityDetailBinding
import com.app.foody.ui.MainViewModel
import com.app.foody.ui.detail.ingredients.IngredientsFragment
import com.app.foody.ui.detail.instructions.InstructionsFragment
import com.app.foody.ui.detail.overview.OverviewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val args by navArgs<DetailActivityArgs>()
    private val mainViewModel: MainViewModel by viewModels()

    private var recipeSaved = false
    private var savedRecipeId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fragments = ArrayList<Fragment>()
        fragments.add(OverviewFragment())
        fragments.add(IngredientsFragment())
        fragments.add(InstructionsFragment())

        val titles = ArrayList<String>()
        titles.add("Overview")
        titles.add("Ingredients")
        titles.add("Instructions")

        val resultBundle = Bundle()
        resultBundle.putParcelable("recipeBundle", args.result)

        val adapter = PagerAdapter(resultBundle, fragments, titles, supportFragmentManager)
        binding.viewPagerDetail.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPagerDetail)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        val menuItem = menu?.findItem(R.id.save_to_favorite)
        checkSavedRecipes(menuItem!!)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else if (item.itemId == R.id.save_to_favorite && !recipeSaved) {
            saveToFavorites(item)
        } else if (item.itemId == R.id.save_to_favorite && recipeSaved) {
            removeFromFavorites(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun checkSavedRecipes(menuItem: MenuItem) {
        mainViewModel.readFavoriteRecipes.observe(this) { favoritesEntity ->
            try {
                for (savedRecipe in favoritesEntity) {
                    if (savedRecipe.result.id == args.result.id) {
                        changeMenuItemColor(menuItem, R.color.yellow)
                        savedRecipeId = savedRecipe.id
                        recipeSaved = true
                    } else {
                        changeMenuItemColor(menuItem, R.color.white)
                    }
                }
            } catch (e: Exception) {
                Log.d("DetailsActivity", e.message.toString())
            }
        }
    }

    private fun saveToFavorites(item: MenuItem) {
        val favoritesEntity =
            FavoriteEntity(
                0,
                args.result
            )
        mainViewModel.insertFavoriteRecipes(favoritesEntity)
        changeMenuItemColor(item, R.color.yellow)
        showSnackBar("Recipe saved.")
        recipeSaved = true
    }

    private fun removeFromFavorites(item: MenuItem) {
        val favoritesEntity =
            FavoriteEntity(
                savedRecipeId,
                args.result
            )
        mainViewModel.deleteFavoriteRecipes(favoritesEntity)
        changeMenuItemColor(item, R.color.white)
        showSnackBar("Removed from Favorites.")
        recipeSaved = false
    }

    private fun showSnackBar(message: String) {
        Toast.makeText(this@DetailActivity, message, Toast.LENGTH_SHORT).show()
    }

    private fun changeMenuItemColor(item: MenuItem, color: Int) {
        item.icon?.setTint(ContextCompat.getColor(this, color))
    }
}
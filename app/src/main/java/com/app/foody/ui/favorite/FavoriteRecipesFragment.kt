package com.app.foody.ui.favorite

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.foody.R
import com.app.foody.databinding.FragmentFavoriteRecipesBinding
import com.app.foody.ui.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteRecipesFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private val adapter: FavoriteRecipesAdapter by lazy {
        FavoriteRecipesAdapter(
            requireActivity(),
            mainViewModel
        )
    }

    private var _binding: FragmentFavoriteRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteRecipesBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = this
        binding.mainViewModel = mainViewModel
        binding.mAdapter = adapter

        setHasOptionsMenu(true)

        setupRecyclerView(binding.rvFavoriteRecipes)

        return binding.root
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorite_recipes_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.deleteAllFavRecipes) {
            mainViewModel.deleteAllFavoriteRecipes()
            showSnackBar("All recipes removed.")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).setAction("Okay") {}.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        adapter.clearContextActualMode()
    }

}
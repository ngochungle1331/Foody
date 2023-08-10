package com.app.foody.ui.detail.ingredients

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.app.foody.R
import com.app.foody.data.network.response.Result
import com.app.foody.databinding.FragmentIngredientsBinding


class IngredientsFragment : Fragment() {

    private val adapter: IngredientsAdapter by lazy { IngredientsAdapter() }
    private lateinit var binding: FragmentIngredientsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIngredientsBinding.inflate(layoutInflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable("recipeBundle")

        setupRecyclerView(binding)
        myBundle?.extendedIngredients?.let {
            adapter.setData(it)
        }
        return binding.root
    }

    private fun setupRecyclerView(binding: FragmentIngredientsBinding) {
        binding.ingredientsRecyclerview.adapter = adapter
        binding.ingredientsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }


}
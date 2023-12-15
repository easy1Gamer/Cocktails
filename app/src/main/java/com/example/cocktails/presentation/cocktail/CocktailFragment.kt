package com.example.cocktails.presentation.cocktail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.cocktails.R
import com.example.cocktails.application.App
import com.example.cocktails.base.Factory
import com.example.cocktails.databinding.FragmentCocktailBinding
import com.example.cocktails.presentation.adapters.CocktailAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class CocktailFragment: Fragment (R.layout.fragment_cocktail) {

    private val cocktailId by lazy { requireArguments().getString("item", "") }

    val binding by viewBinding(FragmentCocktailBinding::bind)

    val viewModel by viewModels<CocktailViewModel> {
        Factory {
            (requireActivity().application as App)
                .getAppComponent()
                .getCocktailViewModel()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CocktailAdapter()
        binding.ingredientsRecyclerView.adapter = adapter
        val layout = LinearLayoutManager(context)
        binding.ingredientsRecyclerView.layoutManager = layout

        viewModel.selectedCocktail(cocktailId)

        lifecycleScope.launch {
            viewModel.uiState().collect{
                if(it.chosenCocktail != null) {

                    binding.cocktailName.text = it.chosenCocktail.name
                    Glide.with(view).load(it.chosenCocktail.src).into(binding.cocktailImage)
                    adapter.submitList(it.chosenCocktail.ingredients)

                }
            }
        }

    }
}
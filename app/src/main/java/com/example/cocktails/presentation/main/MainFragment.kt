package com.example.cocktails.presentation.main

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cocktails.R
import com.example.cocktails.application.App
import com.example.cocktails.base.Factory
import com.example.cocktails.databinding.FragmentMainBinding
import com.example.cocktails.domain.Cocktail
import com.example.cocktails.presentation.adapters.MainAdapter
import com.example.cocktails.presentation.cocktail.CocktailFragment
import kotlinx.coroutines.launch


class MainFragment: Fragment(R.layout.fragment_main) {

    val binding by viewBinding(FragmentMainBinding::bind)

    private val viewModel by viewModels<MainViewModel> {
        Factory {
            (requireActivity().application as App)
                .getAppComponent()
                .getMainViewModel()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MainAdapter (::onClickListener)
        binding.cocktailsRecyclerView.adapter = adapter
        val layout = LinearLayoutManager(context)
        binding.cocktailsRecyclerView.layoutManager = layout
        binding.searchActionButton.setOnClickListener{
            val name = binding.searchlineEditText.text.toString()
            viewModel.onSearchClick(name)
        }
        lifecycleScope.launch {
            viewModel.observeUiState().collect {
                if (it.error == null) {
                    binding.errorEditText.visibility = INVISIBLE
                    binding.cocktailsRecyclerView.visibility = VISIBLE
                    adapter.submitList(it.items)
                } else {
                    binding.errorEditText.visibility = VISIBLE
                    binding.cocktailsRecyclerView.visibility = INVISIBLE
                    binding.errorEditText.text = it.error
                }

            }
        }

    }

    private fun onClickListener(keyitem : Cocktail) {
        val fragment = CocktailFragment()
        fragment.arguments = bundleOf("item" to keyitem.id)
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

}
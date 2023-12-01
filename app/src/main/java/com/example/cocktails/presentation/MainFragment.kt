package com.example.cocktails.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cocktails.R
import com.example.cocktails.databinding.FragmentMainBinding
import com.example.cocktails.presentation.adapters.CocktailsAdapter


class MainFragment: Fragment(R.layout.fragment_main) {

    val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CocktailsAdapter()
        binding.cocktailsRecyclerView.adapter = adapter
        val layout = LinearLayoutManager(context)
        binding.cocktailsRecyclerView.layoutManager =layout
    }
}
package com.example.cocktails.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cocktails.R
import com.example.cocktails.databinding.FragmentCocktailBinding


class CocktailFragment: Fragment (R.layout.cocktails_layout) {

    val binding by viewBinding(FragmentCocktailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
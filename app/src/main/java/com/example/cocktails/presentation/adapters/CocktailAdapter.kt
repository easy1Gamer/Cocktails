package com.example.cocktails.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktails.R
import com.example.cocktails.databinding.IngredientsLayoutBinding
import com.example.cocktails.domain.Cocktail
import com.example.cocktails.domain.Ingredient

class CocktailAdapter(): ListAdapter<Ingredient, CocktailAdapter.ViewHolder>(Diffutil()) {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredients_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = IngredientsLayoutBinding.bind(holder.itemView)
        val item = currentList[position]
        binding.ingredientName.text = item.name
        binding.ingredientMeasure.text = item.measure
    }

    private class Diffutil(): DiffUtil.ItemCallback<Ingredient>() {

        override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
            //закончить позже
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
            return oldItem == newItem
        }
    }
}


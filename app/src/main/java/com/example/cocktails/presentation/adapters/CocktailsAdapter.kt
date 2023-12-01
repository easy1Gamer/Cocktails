package com.example.cocktails.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktails.R
import com.example.cocktails.databinding.CocktailsLayoutBinding
import com.example.cocktails.domain.Cocktail

class CocktailsAdapter(): ListAdapter<Cocktail, CocktailsAdapter.ViewHolder>(Diffutil()) {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cocktails_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val binding = CocktailsLayoutBinding.bind(holder.itemView)

        val item = currentList[position]

        binding.cocktailName.text = item.name

        //binding.root.setOnClickListener{}

        Glide.with(holder.itemView).load(item.src).into(binding.cocktailImage)
    }

    private class Diffutil(): DiffUtil.ItemCallback<Cocktail>() {

        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem == newItem
        }
    }
}

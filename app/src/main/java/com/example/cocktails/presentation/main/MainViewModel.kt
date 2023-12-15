package com.example.cocktails.presentation.main

import androidx.lifecycle.ViewModel
import com.example.cocktails.data.Repository
import com.example.cocktails.domain.Cocktail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class MainViewModel @Inject constructor (
    private val repository: Repository,
): ViewModel() {

    private val state = MutableStateFlow(DataState())

    fun observeUiState() = state.asStateFlow()
    fun onSearchClick(inputText: String) {
        state.update { it.copy(error = null) }
        repository.getCocktailsByName(query = inputText, onFailure = ::onFailure) { items ->
            state.update { it.copy(items = items) }
            saveCocktailsData(items)
        }
    }

    private fun saveCocktailsData(cocktails: List<Cocktail>) {
        repository.insertCocktails(cocktails)
        cocktails.forEach{repository.insertIngredients(it.ingredients, it.id)}
    }

    private fun onFailure(errorText: String) {
        state.update { it.copy(error = errorText) }
    }
}

data class DataState(
    val items: List<Cocktail> = emptyList(),
    val error: String? = null
)
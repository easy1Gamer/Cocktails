package com.example.cocktails.presentation.cocktail

import androidx.lifecycle.ViewModel
import com.example.cocktails.data.Repository
import com.example.cocktails.domain.Cocktail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class CocktailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val state = MutableStateFlow(DataState())

    fun uiState() = state.asStateFlow()
    fun selectedCocktail(cocktailId : String) {
        val cocktail = repository.getLocalCocktailById(cocktailId)
        state.update { it.copy(chosenCocktail = cocktail) }
    }

    private fun onFailure(errorText : String) {
        state.update { it.copy(error = errorText) }
    }


}
data class DataState(
    val chosenCocktail : Cocktail? = null,
    val error : String? = null
)


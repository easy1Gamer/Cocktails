package com.example.cocktails.presentation

import androidx.lifecycle.ViewModel
import com.example.cocktails.data.Repository
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    fun deleteCache() {
        repository.deleteCache()
    }

}
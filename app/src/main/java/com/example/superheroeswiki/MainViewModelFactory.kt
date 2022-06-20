package com.example.superheroeswiki

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.superheroeswiki.network.NetworkRepository

class MainViewModelFactory(private val repository: NetworkRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}
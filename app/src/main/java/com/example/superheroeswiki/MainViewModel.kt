package com.example.superheroeswiki

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val heroesList: MutableLiveData<Response<HeroResults>> = MutableLiveData()

    fun getAllHeroes(){
        viewModelScope.launch {
            val list =repository.getCharacter()
            heroesList.value = list
        }
    }

}
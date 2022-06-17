package com.example.superheroeswiki

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroeswiki.utils.FileManager
import com.example.superheroeswiki.utils.FileManager.PREF_HEROES_VALUE
import com.example.superheroeswiki.data.HeroData
import com.example.superheroeswiki.network.Repository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class MainViewModel(private val repository: Repository) : ViewModel() {

    val heroesList: MutableLiveData<List<HeroData>> = MutableLiveData()

    var value: String? = null

    private fun getHeroesDataFromRemoteStorage() {
        viewModelScope.launch {
            val response = repository.getCharacter()
            val list = response.body()
            value = Gson().toJson(response.body())
            heroesList.value = list
        }
    }

    private fun getHeroesDataFromLocalStorage() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = FileManager.getHeroDataFromStorage(PREF_HEROES_VALUE)
            heroesList.postValue(list)
        }
    }

    private fun downloadDataHeroToLocalStorage(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            FileManager.setHeroDataToStorage(PREF_HEROES_VALUE, value)
        }
    }


    fun storageType() {
        val result: Int
        val file = File(FILE_PATH)
        result = if (!file.exists()) {
            REMOTE_STORAGE
        } else {
            LOCAL_STORAGE
        }
        when (result) {
            LOCAL_STORAGE -> getHeroesDataFromLocalStorage()
            REMOTE_STORAGE -> {
                getHeroesDataFromRemoteStorage()
                value?.let { downloadDataHeroToLocalStorage(it) }
            }
        }
    }

    companion object {
        @SuppressLint("SdCardPath")
        const val FILE_PATH =
            "/data/data/com.example.superheroeswiki/shared_prefs/HeroesDataStorageSP.xml"
        const val LOCAL_STORAGE = 0
        const val REMOTE_STORAGE = 1
    }
}
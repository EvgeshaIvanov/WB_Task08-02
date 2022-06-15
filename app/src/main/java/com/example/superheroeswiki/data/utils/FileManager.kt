package com.example.superheroeswiki.data.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.superheroeswiki.data.HeroData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


object FileManager {

    private const val PREFERENCES_HEROES_FILE_NAME = "HeroesDataStorageSP"

    const val PREF_HEROES_VALUE = "PREF_HEROES_VALUE"

    lateinit var sharedPreferences: SharedPreferences

    fun with(application: Application) {
        sharedPreferences = application.getSharedPreferences(
            PREFERENCES_HEROES_FILE_NAME,
            Context.MODE_PRIVATE
        )
    }

    fun setHeroDataToStorage(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getHeroDataFromStorage(key: String): List<HeroData> {
        val data = sharedPreferences.getString(key, "")
        val type: Type = object : TypeToken<List<HeroData>>() {}.type
        return Gson().fromJson(data, type)
    }
}
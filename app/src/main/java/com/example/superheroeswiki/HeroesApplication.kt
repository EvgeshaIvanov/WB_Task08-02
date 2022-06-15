package com.example.superheroeswiki

import android.app.Application
import com.example.superheroeswiki.data.FileManager

class HeroesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FileManager.with(this)
    }
}
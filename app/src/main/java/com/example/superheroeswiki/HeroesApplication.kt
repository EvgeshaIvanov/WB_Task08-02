package com.example.superheroeswiki

import android.app.Application
import com.example.superheroeswiki.data.utils.FileManager
import com.github.terrakok.cicerone.Cicerone

class HeroesApplication : Application() {

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        FileManager.with(this)
    }

    companion object {
        internal lateinit var INSTANCE: HeroesApplication
            private set
    }
}
package com.example.superheroeswiki.ui.navigation

import android.os.Bundle
import com.example.superheroeswiki.ui.aboutApp.AboutFragment
import com.example.superheroeswiki.ui.heroDetail.DetailHeroFragment
import com.example.superheroeswiki.ui.heroes.HeroesFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun mainScreen() = FragmentScreen { HeroesFragment() }

    fun aboutScreen() = FragmentScreen { AboutFragment() }

    fun sendData(bundle: Bundle) = FragmentScreen { DetailHeroFragment.newInstance(bundle) }
}
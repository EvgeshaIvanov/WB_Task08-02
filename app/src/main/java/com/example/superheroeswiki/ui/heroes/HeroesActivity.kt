package com.example.superheroeswiki.ui.heroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroeswiki.HeroesApplication
import com.example.superheroeswiki.R
import com.example.superheroeswiki.databinding.ActivityHeroesMainBinding
import com.example.superheroeswiki.ui.navigation.Screens
import com.github.terrakok.cicerone.androidx.AppNavigator


class HeroesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesMainBinding

    private val navigator = AppNavigator(this, R.id.container_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.aboutBtn.setOnClickListener {
            HeroesApplication.INSTANCE.router.navigateTo(Screens.aboutScreen())
        }
        HeroesApplication.INSTANCE.router.newRootScreen(Screens.mainScreen())

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        HeroesApplication.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        HeroesApplication.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }

}


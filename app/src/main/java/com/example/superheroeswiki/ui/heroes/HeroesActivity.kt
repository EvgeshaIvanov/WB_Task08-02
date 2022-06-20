package com.example.superheroeswiki.ui.heroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroeswiki.HeroesApplication
import com.example.superheroeswiki.R
import com.example.superheroeswiki.databinding.ActivityHeroesMainBinding
import com.example.superheroeswiki.utils.Screens
import com.github.terrakok.cicerone.androidx.AppNavigator


class HeroesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesMainBinding

    private val navigator = AppNavigator(this, R.id.container_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        if (savedInstanceState == null) {
            HeroesApplication.INSTANCE.router.newRootScreen(Screens.mainScreen())
        }
        binding.aboutBtn.setOnClickListener {
            HeroesApplication.INSTANCE.router.newChain(Screens.aboutScreen())
        }

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


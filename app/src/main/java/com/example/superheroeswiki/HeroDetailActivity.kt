package com.example.superheroeswiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroeswiki.databinding.ActivityHeroDetailBinding

class HeroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val heroName = intent.getStringExtra("HERO_NAME")
        val heroPlaceOfBirth = intent.getStringExtra("HERO_PLACE_OF_BIRTH")
        binding.heroName.text = heroName
        binding.placeOfBirth.text = heroPlaceOfBirth
    }
}
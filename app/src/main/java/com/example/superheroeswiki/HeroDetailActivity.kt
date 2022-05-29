package com.example.superheroeswiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.superheroeswiki.databinding.ActivityHeroDetailBinding
import com.example.superheroeswiki.model.HeroData
import com.squareup.picasso.Picasso

class HeroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val heroDetails = intent.getParcelableExtra<HeroData>("HERO_NAME")!!

        binding.apply {
            setImage(heroDetails.image.url, heroImage)
            heroName.text = heroDetails.name
            if (heroDetails.biography.fullName.contains("")) {
                fullNameHeroInfo.text = MISS_TEXT
            } else fullNameHeroInfo.text = heroDetails.biography.fullName
            genderInfo.text = heroDetails.appearance.gender
            if (heroDetails.appearance.race.contains("null")) {
                raceInfo.text = MISS_TEXT
            } else raceInfo.text = heroDetails.appearance.race
            placeOfBirthInfo.text = heroDetails.biography.placeOfBirth
            publisherInfo.text = heroDetails.biography.publisher
        }


    }

    private fun setImage(url: String, imageView: ImageView) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .fit()
            .error(R.drawable.hero_error_image)
            .into(imageView)
    }

    companion object {
        const val MISS_TEXT = "-"
    }
}
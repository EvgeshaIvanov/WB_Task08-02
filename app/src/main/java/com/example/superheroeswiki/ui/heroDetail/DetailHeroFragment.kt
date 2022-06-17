package com.example.superheroeswiki.ui.heroDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.superheroeswiki.R
import com.example.superheroeswiki.data.HeroData
import com.example.superheroeswiki.databinding.FragmentDetailHeroBinding
import com.example.superheroeswiki.ui.heroes.HeroesFragment.Companion.HERO_DETAILS
import com.squareup.picasso.Picasso


class DetailHeroFragment : Fragment() {

    private lateinit var binding: FragmentDetailHeroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailHeroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val heroDetails = arguments?.getParcelable<HeroData>(HERO_DETAILS)!!
        initHeroDetails(heroDetails)
    }

    private fun initHeroDetails(heroDetails: HeroData) {
        binding.apply {
            setImage(heroDetails.image.url, heroImage)
            heroName.text = heroDetails.name
            if (heroDetails.biography.fullName == EMPTY_TEXT) {
                fullNameHeroInfo.text = MISS_TEXT
            } else fullNameHeroInfo.text = heroDetails.biography.fullName
            genderInfo.text = heroDetails.appearance.gender
            if (heroDetails.appearance.race == null) {
                raceInfo.text = MISS_TEXT
            } else raceInfo.text = heroDetails.appearance.race
            placeOfBirthInfo.text = heroDetails.biography.placeOfBirth
            if (heroDetails.biography.publisher == EMPTY_TEXT) {
                publisherInfo.text = MISS_TEXT
            } else publisherInfo.text = heroDetails.biography.publisher
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
        fun newInstance(bundle: Bundle): DetailHeroFragment {
            val fragment = DetailHeroFragment()
            fragment.arguments = bundle
            return fragment
        }

        const val MISS_TEXT = "-"
        const val EMPTY_TEXT = ""
    }

}
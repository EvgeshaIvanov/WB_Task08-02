package com.example.superheroeswiki.ui.aboutApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.example.superheroeswiki.HeroesApplication
import com.example.superheroeswiki.databinding.FragmentAboutBinding
import com.example.superheroeswiki.utils.Screens


class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            HeroesApplication.INSTANCE.router.backTo(Screens.mainScreen())
        }
        return binding.root
    }
}
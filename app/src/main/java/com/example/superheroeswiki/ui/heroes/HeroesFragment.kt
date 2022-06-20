package com.example.superheroeswiki.ui.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroeswiki.HeroesApplication
import com.example.superheroeswiki.MainViewModel
import com.example.superheroeswiki.MainViewModelFactory
import com.example.superheroeswiki.databinding.FragmentHeroesBinding
import com.example.superheroeswiki.network.ApiClient
import com.example.superheroeswiki.network.NetworkRepository
import com.example.superheroeswiki.utils.Screens


class HeroesFragment : Fragment() {

    private lateinit var binding: FragmentHeroesBinding

    private lateinit var viewModel: MainViewModel

    private lateinit var heroesAdapter: HeroesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRecyclerView()
        heroesAdapter.onClickHeroListener = { hero ->
            val bundle = Bundle().apply { putParcelable(HERO_DETAILS, hero) }
            HeroesApplication.INSTANCE.router.navigateTo(Screens.detailScreen(bundle))
        }
    }

    private fun initViewModel() {
        val repository = NetworkRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.storageType()
        viewModel.heroesList.observe(viewLifecycleOwner) {
            heroesAdapter.list = it
        }

    }


    private fun initRecyclerView() {
        heroesAdapter = HeroesAdapter()
        binding.recyclerViewHeroes.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = heroesAdapter
        }
    }

    companion object {
        const val HERO_DETAILS = "HERO"
    }

}
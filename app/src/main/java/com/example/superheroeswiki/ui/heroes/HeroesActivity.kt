package com.example.superheroeswiki.ui.heroes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroeswiki.MainViewModel
import com.example.superheroeswiki.MainViewModel.Companion.LOCAL_STORAGE
import com.example.superheroeswiki.MainViewModel.Companion.REMOTE_STORAGE
import com.example.superheroeswiki.MainViewModelFactory
import com.example.superheroeswiki.databinding.ActivityHeroesMainBinding
import com.example.superheroeswiki.network.Repository
import com.example.superheroeswiki.ui.heroDetail.HeroDetailActivity
import com.google.gson.Gson


class HeroesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesMainBinding

    private lateinit var viewModel: MainViewModel

    private lateinit var heroesAdapter: HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        initRecyclerView()

        heroesAdapter.onClickHeroListener = { hero ->
            val intent = Intent(this, HeroDetailActivity::class.java)
            intent.putExtra(HERO_DETAILS, hero)

            startActivity(intent)
        }

    }

    private fun initViewModel() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        when (viewModel.storageType()) {
            REMOTE_STORAGE -> {
                viewModel.heroesList.observe(this) { response ->
                    heroesAdapter.list = response.body()!!
                    val heroDataFromJson = Gson().toJson(response.body())
                    viewModel.downloadDataHeroToLocalStorage(heroDataFromJson)
                }
            }
            LOCAL_STORAGE -> {
                viewModel.heroesListFromStorage.observe(this) { response ->
                    heroesAdapter.list = response
                }
            }
        }
    }


    private fun initRecyclerView() {
        heroesAdapter = HeroesAdapter()
        binding.recyclerViewHeroes.apply {
            layoutManager = LinearLayoutManager(this@HeroesActivity)
            adapter = heroesAdapter
        }
    }

    companion object {
        const val HERO_DETAILS = "HERO"
    }
}
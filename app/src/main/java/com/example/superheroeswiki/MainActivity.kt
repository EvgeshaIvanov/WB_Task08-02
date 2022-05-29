package com.example.superheroeswiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroeswiki.databinding.ActivityMainBinding
import com.example.superheroeswiki.network.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    private lateinit var heroesAdapter: HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        initRecyclerView()

        heroesAdapter.onClickHeroListener = { hero ->
            Log.i("HERO_CLICK_INFO", "${hero.name}, full name - ${hero.biography.fullName}")
            val intent = Intent(this, HeroDetailActivity::class.java)
            intent.putExtra("HERO_NAME", hero)

            startActivity(intent)
        }

    }

    private fun initViewModel() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getAllHeroes()
        viewModel.heroesList.observe(this) { response ->
            if (response.isSuccessful) {
                heroesAdapter.list = response.body()!!.results
            }
        }
    }

    private fun initRecyclerView() {
        heroesAdapter = HeroesAdapter()
        binding.recyclerViewHeroes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = heroesAdapter
        }
    }
}
package com.example.superheroeswiki.network

import com.example.superheroeswiki.model.HeroResults
import retrofit2.Response

class Repository {

    suspend fun getCharacter(): Response<HeroResults> {
        return RetrofitInstance.api.getHeroesList()
    }

}
package com.example.superheroeswiki.network

import com.example.superheroeswiki.data.HeroData
import retrofit2.Response

class Repository {

    suspend fun getCharacter(): Response<List<HeroData>> {
        return RetrofitInstance.api.getHeroesList()
    }

}
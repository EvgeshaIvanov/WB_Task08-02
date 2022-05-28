package com.example.superheroeswiki

import retrofit2.Response

class Repository {

    suspend fun getCharacter(): Response<HeroResults> {
        return RetrofitInstance.api.getHeroesList()
    }

}
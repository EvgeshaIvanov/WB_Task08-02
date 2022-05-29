package com.example.superheroeswiki.network

import com.example.superheroeswiki.model.HeroResults
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("search/_")
    suspend fun getHeroesList(): Response<HeroResults>
}
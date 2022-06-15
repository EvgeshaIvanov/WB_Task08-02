package com.example.superheroeswiki.network

import com.example.superheroeswiki.data.HeroData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("all.json")
    suspend fun getHeroesList(): Response<List<HeroData>>
}
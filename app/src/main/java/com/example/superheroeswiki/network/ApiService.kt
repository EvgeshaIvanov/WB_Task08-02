package com.example.superheroeswiki.network

import com.example.superheroeswiki.data.HeroData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
//TODO сервис не работает superheroapi.com 09.10.22 - 10.06.22
    //@GET("search/_")
    @GET("all.json")
    suspend fun getHeroesList(): Response<List<HeroData>>
}
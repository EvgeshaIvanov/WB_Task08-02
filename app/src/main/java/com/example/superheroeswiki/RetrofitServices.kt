package com.example.superheroeswiki

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {

    @GET("search/_")
    suspend fun getHeroesList(): Response<HeroResults>
}
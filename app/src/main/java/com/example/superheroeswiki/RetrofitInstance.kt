package com.example.superheroeswiki

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://www.superheroapi.com/api.php/544500524015660/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: RetrofitServices by lazy {
        retrofit.create(RetrofitServices::class.java)
    }
}
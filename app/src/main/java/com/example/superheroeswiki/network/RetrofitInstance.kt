package com.example.superheroeswiki.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
    val apiClient = ApiClient(api)
}
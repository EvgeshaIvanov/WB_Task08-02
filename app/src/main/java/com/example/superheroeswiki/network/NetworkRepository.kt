package com.example.superheroeswiki.network

import com.example.superheroeswiki.data.HeroData

class NetworkRepository {

    suspend fun getCharacter(): List<HeroData>? {
        val request = RetrofitInstance.apiClient.getCharacter()
        if (request.failed) {
            return null
        }
        if (!request.isSuccessful) {
            return null
        }

        return request.body

    }

}
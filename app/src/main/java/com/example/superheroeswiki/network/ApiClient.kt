package com.example.superheroeswiki.network

import com.example.superheroeswiki.data.HeroData
import retrofit2.Response

class ApiClient(
    private val apiService: ApiService
) {

    suspend fun getCharacter(): NetworkResponse<List<HeroData>> {
        return apiCall { apiService.getHeroesList() }
    }

    private inline fun <T> apiCall(apiCall: () -> Response<T>): NetworkResponse<T> {
        return try {
            NetworkResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            NetworkResponse.failure(e)
        }
    }
}
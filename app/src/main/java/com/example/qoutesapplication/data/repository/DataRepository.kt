package com.example.qoutesapplication.data.repository

import com.example.qoutesapplication.data.api.ApiService

class DataRepository(val apiService: ApiService) {
    suspend fun getQuotes() = apiService.getQuotes()
}

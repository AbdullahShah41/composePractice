package com.example.qoutesapplication.data.api

import com.example.qoutesapplication.data.model.QuotesDTO
import retrofit2.http.GET

interface ApiService {
    @GET("/quotes/random")
    suspend fun getQuotes(): List<QuotesDTO>
}
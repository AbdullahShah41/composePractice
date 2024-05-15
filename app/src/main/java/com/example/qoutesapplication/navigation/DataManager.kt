package com.example.qoutesapplication.navigation

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.qoutesapplication.Pages
import com.example.qoutesapplication.data.model.QuoteLocalDTO
import com.example.qoutesapplication.data.model.QuotesDTO
import com.google.gson.Gson
import kotlin.io.encoding.Base64

object DataManager {

    var quotesData = emptyArray<QuoteLocalDTO>()
    var isDataLoaded = mutableStateOf(false)
    // HELPER for navigation
    var currentPage = mutableStateOf(Pages.LISTING_PAGE)
    // For tracking the current quote
    var currentQuoteLocalDTO: QuoteLocalDTO? = null
    // For Tracking current Api Quote
    var currentQuoteApiDTO: QuotesDTO? = null

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("qoutes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quotesData = gson.fromJson(json, Array<QuoteLocalDTO>::class.java)
        isDataLoaded.value = true
    }


    fun switchPagesApi(currentQuoteParamApi: QuotesDTO) {
        when (currentPage.value) {
            // Selection medium
            Pages.SELECTION_MEDIUM -> {

            }
            // Api Quotes
            Pages.API_LISTING_PAGE -> {
                currentPage.value = Pages.DETAIL_PAGE
            }
            // Local Quotes
            Pages.LISTING_PAGE -> {
                currentQuoteApiDTO = currentQuoteParamApi
                currentPage.value = Pages.DETAIL_PAGE
            }
            // Quote Detail View
            Pages.DETAIL_PAGE -> {
                currentPage.value = Pages.LISTING_PAGE
            }
        }
    }

// Local page navigation
    fun switchPages(currentQuoteParamLocalDTO: QuoteLocalDTO){

    if (currentPage.value == Pages.LISTING_PAGE){
        currentQuoteLocalDTO = currentQuoteParamLocalDTO
        Log.i("page", "Current quote in DataManager if $currentQuoteLocalDTO")
        currentPage.value = Pages.DETAIL_PAGE
    }else {
        currentPage.value = Pages.LISTING_PAGE
        Log.i("page", "Current quote in DataManager else $currentQuoteLocalDTO")

    }


        }



/*        fun switchPages(currentQuoteParamLocalDTO: QuoteLocalDTO){
        if (currentPage.value == Pages.LISTING_PAGE){
            currentQuoteLocalDTO = currentQuoteParamLocalDTO
            Log.i("page", "Current quote in DataManager if $currentQuoteLocalDTO")
            currentPage.value = Pages.DETAIL_PAGE
        }else {
            currentPage.value = Pages.LISTING_PAGE
            Log.i("page", "Current quote in DataManager else $currentQuoteLocalDTO")

        }*/


}
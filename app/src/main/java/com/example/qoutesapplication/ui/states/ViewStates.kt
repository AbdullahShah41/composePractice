package com.example.qoutesapplication.ui.states

import com.example.qoutesapplication.data.model.QuotesDTO

sealed class ViewStates {
    object idle : ViewStates()
    object loading : ViewStates()
    class failure(val errorMessage: String) : ViewStates()
    // Passing the model class,  if anything happens then pass QuotesDTOItem instead which is bare model
    class success(val dataList: List<QuotesDTO>) : ViewStates()
}



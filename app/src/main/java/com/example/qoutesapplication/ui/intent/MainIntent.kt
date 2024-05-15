package com.example.qoutesapplication.ui.intent

sealed class MainIntent {
    data object getQuotes : MainIntent()
}
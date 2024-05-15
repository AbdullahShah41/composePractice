package com.example.qoutesapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.qoutesapplication.navigation.DataManager
import com.example.qoutesapplication.screens.QuoteDetails
import com.example.qoutesapplication.screens.QuoteList
import com.example.qoutesapplication.ui.theme.QoutesApplicationTheme
import com.example.qoutesapplication.ui.viewmodel.DataViewModel


class MainActivity : ComponentActivity() {

    private val viewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        DataManager.loadAssetsFromFile(this)

        setContent {
            QoutesApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    println("innerPadding $innerPadding")
                    App()

                }
            }
        }
    }
}


@Composable
fun App() {
    if (DataManager.isDataLoaded.value){
        if (DataManager.currentPage.value == Pages.API_LISTING_PAGE){
            QuoteList(data = DataManager.quotesAPIData) { currentQuote ->
                Log.i("click", "Current quote in main activity ${currentQuote}")
                println("Current quote in main listing page $currentQuote")
                DataManager.switchPagesApi(currentQuote)
            }
        }else {
            DataManager.currentQuoteLocalDTO?.let { QuoteDetails(quoteLocalDTO = it) { }
            }
        }
    }
}




/*
* @Composable
fun App() {
    if (DataManager.isDataLoaded.value){
        if (DataManager.currentPage.value == Pages.LISTING_PAGE){
            QuoteList(data = DataManager.quotesData) { currentQuote ->
                Log.i("click", "Current quote in main activity ${currentQuote}")
                println("Current quote in main listing page $currentQuote")
                DataManager.switchPages(currentQuote)
            }
        }else {
            DataManager.currentQuoteLocalDTO?.let { QuoteDetails(quoteLocalDTO = it) { }
            }
        }
    }
}
* */

enum class Pages {
    SELECTION_MEDIUM, LISTING_PAGE, DETAIL_PAGE, API_LISTING_PAGE
}





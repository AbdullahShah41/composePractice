package com.example.qoutesapplication.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.qoutesapplication.data.model.QuoteLocalDTO

@Preview()
@Composable
fun  QuoteList(data : Array<QuoteLocalDTO>, onQuoteClick : (quoteLocalDTO: QuoteLocalDTO) -> Unit) {
    LazyColumn ( content = {
        items(data) {
            QuoteListItem(quoteLocalDTO = it, onQuoteClick)
        }
     }
    )
}

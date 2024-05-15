package com.example.qoutesapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.remember


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.qoutesapplication.Pages
import com.example.qoutesapplication.R
import com.example.qoutesapplication.data.model.QuoteLocalDTO
import com.example.qoutesapplication.navigation.DataManager

@Preview (showBackground = true)
@Composable
fun QuoteDetails(quoteLocalDTO: QuoteLocalDTO, onClick: (quoteLocalDTO: QuoteLocalDTO) -> Unit) {

    val quoteFont = remember { FontFamily(Font(R.font.quote_font)) }
    val authorFont = remember { FontFamily(Font(R.font.author_font)) }

    DataManager.currentPage.value = Pages.DETAIL_PAGE

    Box(
        modifier = Modifier.fillMaxSize(1f),
        contentAlignment = Alignment.Center
    ) {
        Brush.sweepGradient(
            colors = listOf(
                Color("#FFFFFF".toColorInt()),
                Color("#000000".toColorInt()))
        )

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 22.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
                    .clickable { onClick(quoteLocalDTO) }) {

                Image(imageVector = Icons.Default.Edit,
                    modifier = Modifier.size(40.dp),
                    contentDescription =  "Quote Icon")

                Text(text = quoteLocalDTO.quote,
                    fontFamily = quoteFont,
                    style = MaterialTheme.typography.headlineLarge)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = quoteLocalDTO.author,
                    fontFamily = authorFont,
                    style = MaterialTheme.typography.bodySmall)


            }
        }

    }
}
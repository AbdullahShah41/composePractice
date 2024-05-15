package com.example.qoutesapplication.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.qoutesapplication.R
import com.example.qoutesapplication.data.model.QuoteLocalDTO

@Preview(showBackground = true)
@Composable
fun QuoteListItem(quoteLocalDTO: QuoteLocalDTO, onClick: (quoteLocalDTO: QuoteLocalDTO) -> Unit) {

    val quoteFont = remember { FontFamily(Font(R.font.quote_font)) }
    val authorFont = remember { FontFamily(Font(R.font.author_font)) }

    ElevatedCard (elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick(quoteLocalDTO)
                Log.i("click", "Current quote in QuoteListItem ${quoteLocalDTO.quote}")
                Log.i("click", "Current author in QuoteListItem ${quoteLocalDTO.author}")
            }){

        Row (modifier = Modifier.padding(8.dp)) {

            Image(imageVector = Icons.Default.Create,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .background(color = Color.Black),
                contentDescription = "icon_quote")

            Spacer(modifier = Modifier.padding(4.dp))

            Column (modifier = Modifier.weight(1f)) {
//            Quote TextView
                Text(text = quoteLocalDTO.quote,
                    fontFamily = quoteFont,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(0.dp,0.dp,0.dp,4.dp))

//            Separator Line
                Box(modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth(.4f)
                    .height(1.dp))

                Text(text = quoteLocalDTO.author,
                    fontFamily = authorFont,
                    color = Color("#373737".toColorInt()),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
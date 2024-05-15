package com.example.qoutesapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
    @Composable
    fun ScreenSelection(onClick: () -> Unit){

        Box(modifier = Modifier
            .background(Color.White)
            .fillMaxSize()){

            Row (
                Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){

//                Local Quotes
                ElevatedCard (elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier
                        .height(140.dp)
                        .width(170.dp).clickable { onClick() }) {

                    Column (modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally),
                        verticalArrangement = Arrangement.Center) {
                        // Local Quotes
                        Image(
                            imageVector = Icons.Default.Create,
                            contentDescription = "Local Icons",
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp)
                                .padding(horizontal = 4.dp, vertical = 4.dp))
                        Text(
                            text = "Local Quotes",
                            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)
                    }

                }

//                Api Quotes
                ElevatedCard (elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier
                        .height(140.dp)
                        .width(170.dp)
                        .clickable { onClick()}
                ) {

                    Column (modifier = Modifier.fillMaxHeight().align(Alignment.CenterHorizontally), verticalArrangement = Arrangement.Center) {
                        // Local Quotes
                        // Api Quotes
                        Image(imageVector = Icons.Default.Edit,
                            contentDescription = "Api Quotes",
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp)
                                .padding(horizontal = 4.dp, vertical = 4.dp))

                        Text(text = "Api Quotes", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

                    }

                }



            }


    }

}
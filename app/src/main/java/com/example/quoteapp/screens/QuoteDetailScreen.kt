package com.example.quoteapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quoteapp.DataManager
import com.example.quoteapp.models.Quote


@Composable
fun QuoteDetailScreen(quote: Quote) {

    BackHandler {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )

    ) {

        Card (
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(2.dp),
            modifier = Modifier
                .padding(32.dp)
                .clickable { }

        ){

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp,24.dp)
            ) {

                Image(
                    imageVector = Icons.Filled.FormatQuote ,
                    contentDescription = "Quote",
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(180f)
                )

                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)
                )

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Thin
                )

            }

        }

    }
}
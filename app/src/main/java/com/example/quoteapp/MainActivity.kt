package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.models.Quote
import com.example.quoteapp.screens.QuoteDetailScreen
import com.example.quoteapp.screens.QuoteListScreen
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch{
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
          MyApp()
        }
    }
}


@Composable
fun MyApp() {
    if(DataManager.isDataLoaded.value){

        if(DataManager.currentPage.value == Pages.LISTING){
            QuoteListScreen(data = DataManager.data) {
            DataManager.switchPages(it)

            }
        }else{
            DataManager.quoteData?.let { QuoteDetailScreen(quote = it)}

        }

    }

}

enum class Pages{
    LISTING,
    DETAIL
}

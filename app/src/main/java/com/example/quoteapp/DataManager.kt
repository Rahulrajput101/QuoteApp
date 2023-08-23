package com.example.quoteapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.quoteapp.models.Quote
import com.google.gson.Gson
import java.io.InputStream
import java.nio.charset.Charset

object DataManager {

    var data  = emptyArray<Quote>()
    var quoteData : Quote? = null
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded : MutableState<Boolean> =  mutableStateOf(false)
    fun loadAssetsFromFile(context : Context){
       val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value = true

    }

    fun switchPages(quote: Quote?){
        if(currentPage.value == Pages.LISTING){
            quoteData =quote
            currentPage.value = Pages.DETAIL
            Log.v("State2", currentPage.value.toString())
        }else{
            currentPage.value = Pages.LISTING
        }


    }


}
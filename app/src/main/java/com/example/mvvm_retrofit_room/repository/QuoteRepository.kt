package com.example.mvvm_retrofit_room.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_retrofit_room.QuoteApplication
import com.example.mvvm_retrofit_room.api.QuotesApi
import com.example.mvvm_retrofit_room.db.QuoteDatabase
import com.example.mvvm_retrofit_room.model.QuoteLIst
import com.example.mvvm_retrofit_room.util.NetworkUtils

class QuoteRepository(
    private val quotesApi: QuotesApi,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {
    private val quotesLiveData = MutableLiveData<QuoteLIst>()
    val quotes: LiveData<QuoteLIst>
        get() = quotesLiveData


    suspend fun getQuotes() {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = quotesApi.getQuotes()
            if (result.body() != null) {
                quoteDatabase.getDao().AddQuote(result.body()!!.quotes)
                quotesLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.getDao().getQuotes()
            val quotelist = QuoteLIst(1,2,quotes,1,5)
            quotesLiveData.postValue(quotelist)
        }
    }

}
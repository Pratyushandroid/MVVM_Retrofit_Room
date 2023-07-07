package com.example.mvvm_retrofit_room

import android.app.Application
import com.example.mvvm_retrofit_room.api.QuotesApi
import com.example.mvvm_retrofit_room.api.RetrofitHelper
import com.example.mvvm_retrofit_room.db.QuoteDatabase
import com.example.mvvm_retrofit_room.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quotesApi,quoteDatabase,applicationContext)
    }
}
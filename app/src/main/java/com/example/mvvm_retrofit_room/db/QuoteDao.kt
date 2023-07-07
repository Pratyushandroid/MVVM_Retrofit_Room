package com.example.mvvm_retrofit_room.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm_retrofit_room.model.Quote
import com.example.mvvm_retrofit_room.model.QuoteLIst

@Dao
interface QuoteDao {

    @Insert
    suspend fun AddQuote(quote: List<Quote>)

    @Query("Select * From QuoteTable")
    suspend fun getQuotes(): List<Quote>
}
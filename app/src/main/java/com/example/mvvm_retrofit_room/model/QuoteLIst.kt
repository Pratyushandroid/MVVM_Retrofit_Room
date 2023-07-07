package com.example.mvvm_retrofit_room.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class QuoteLIst(
    val id:Int,
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)
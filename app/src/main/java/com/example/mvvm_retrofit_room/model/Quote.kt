package com.example.mvvm_retrofit_room.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "QuoteTable")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val i_d_1: Int,
    val author: String,
    val id: Int,
    val quote: String
)
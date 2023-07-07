package com.example.mvvm_retrofit_room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_retrofit_room.model.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase:RoomDatabase() {

    abstract fun getDao():QuoteDao

    companion object{

        @Volatile
        private var Instance:QuoteDatabase ?=null

        fun getDatabase(context: Context):QuoteDatabase{
       if (Instance == null){
           synchronized(this){
               Instance = Room.databaseBuilder(
                   context,
                   QuoteDatabase::class.java,
                   "quote.db"
               ).build()
           }
       }
            return Instance!!
        }
    }
}
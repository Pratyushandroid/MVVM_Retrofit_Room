package com.example.mvvm_retrofit_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_retrofit_room.databinding.ActivityMainBinding
import com.example.mvvm_retrofit_room.repository.QuoteRepository
import com.example.mvvm_retrofit_room.viewmodel.MainViewModel
import com.example.mvvm_retrofit_room.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.quotes.observe(this, Observer {
            val res = it.quotes
            Toast.makeText(this@MainActivity, res.size.toString(), Toast.LENGTH_LONG).show()
//            res.forEach {
//                Log.d("PP", it.quote.toString())
//            }
        })

    }
}
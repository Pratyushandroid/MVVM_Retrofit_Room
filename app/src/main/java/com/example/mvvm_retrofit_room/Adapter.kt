package com.example.mvvm_retrofit_room

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mvvm_retrofit_room.model.Quote
import com.example.mvvm_retrofit_room.model.QuoteLIst

class Adapter(val quoteslist:List<Quote>):RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(item:View):RecyclerView.ViewHolder(item){
        val id = item.findViewById<TextView>(R.id.quoteid)
        val quotee = item.findViewById<TextView>(R.id.quote)
        val author = item.findViewById<TextView>(R.id.author)

       fun bind(quoteslist: QuoteLIst){
//           id.text =quoteslist.quotes.
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
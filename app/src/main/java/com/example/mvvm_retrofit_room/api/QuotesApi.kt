package com.example.mvvm_retrofit_room.api

import com.example.mvvm_retrofit_room.model.QuoteLIst
import retrofit2.Response
import retrofit2.http.GET


interface QuotesApi {

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteLIst>
    // for passing Query inside End Point
    // suspend fun getQuotes(@Query("page")Page:Int):Response<QuoteLIst>

    // BASE_URL + /quotes?page=1


}
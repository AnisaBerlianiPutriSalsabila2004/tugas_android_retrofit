package com.example.retrofit2.Network

import com.example.retrofit2.Model.dataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("data.php")
    fun getCharacters(): Call<dataModel>
}
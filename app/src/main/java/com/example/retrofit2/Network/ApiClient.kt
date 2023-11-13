package com.example.retrofit2.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getInstance(): ApiService{

        val baseUrl = "https://demo.lazday.com/rest-api-sample/"

        val mHttpLoggingInterceptor = HttpLoggingInterceptor().setLevel((HttpLoggingInterceptor.Level.BODY))

        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()

        return builder.create(ApiService::class.java)
    }
}
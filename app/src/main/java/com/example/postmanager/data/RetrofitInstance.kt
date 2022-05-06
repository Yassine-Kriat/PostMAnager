package com.example.postmanager.data

import com.example.postmanager.utils.Constants.Companion.WEB_SERVICE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(WEB_SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api: PostService by lazy {
        retrofit.create(PostService::class.java)
    }
}
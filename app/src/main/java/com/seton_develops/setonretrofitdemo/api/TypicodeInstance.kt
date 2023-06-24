package com.seton_develops.setonretrofitdemo.api

import com.seton_develops.setonretrofitdemo.api.TypicodeAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URL: String = "https://jsonplaceholder.typicode.com"

object TypicodeInstance {
    //by lazy means that we will initialize when we use it
    val api: TypicodeAPI by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TypicodeAPI::class.java)
    }
}
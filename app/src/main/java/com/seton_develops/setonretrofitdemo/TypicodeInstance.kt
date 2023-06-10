package com.seton_develops.setonretrofitdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URL: String = "https://jsonplaceholder.typicode.com"

object TypicodeInstance {
    val api: TypicodeAPI by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TypicodeAPI::class.java)
    }
}
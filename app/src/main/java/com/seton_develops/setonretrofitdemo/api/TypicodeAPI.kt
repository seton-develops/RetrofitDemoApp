package com.seton_develops.setonretrofitdemo.api

import com.seton_develops.setonretrofitdemo.model.TypicodeData
import retrofit2.Response
import retrofit2.http.GET

interface TypicodeAPI {

    @GET("/posts")
    suspend fun getPosts(): Response<List<TypicodeData>>

    @GET("/posts/1")
    suspend fun getPost(): Response<TypicodeData>

}
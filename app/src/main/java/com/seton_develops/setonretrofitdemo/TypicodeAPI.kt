package com.seton_develops.setonretrofitdemo

import retrofit2.Response
import retrofit2.http.GET

interface TypicodeAPI {

    @GET("/posts")
    suspend fun getPosts(): Response<List<TypicodeData>>

    @GET("/posts")
    suspend fun getPost(): Response<TypicodeData>

}
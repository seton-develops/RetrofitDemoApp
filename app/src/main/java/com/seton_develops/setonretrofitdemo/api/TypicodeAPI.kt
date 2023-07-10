package com.seton_develops.setonretrofitdemo.api

import com.seton_develops.setonretrofitdemo.model.TypicodeData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TypicodeAPI {

//    @GET("/posts")
//    suspend fun getPosts(): Response<List<TypicodeData>>

//    @GET("/posts/{id}")
//    public Call<UserApiResponse> getUser(@Path("id") Long id);

    @GET("/posts/{id}")
    suspend fun getSpecificPost(@Path("id") id: Long): Response<TypicodeData>

    @GET("/posts/1")
    suspend fun getPost(): Response<TypicodeData>

}
package com.seton_develops.setonretrofitdemo.repository

import com.seton_develops.setonretrofitdemo.api.TypicodeInstance
import com.seton_develops.setonretrofitdemo.model.TypicodeData
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<TypicodeData> {
        return TypicodeInstance.api.getPost()
    }

    suspend fun getSpecificPost(id: Long): Response<TypicodeData> {
        return TypicodeInstance.api.getSpecificPost(id)
    }
}

package com.seton_develops.setonretrofitdemo.utils

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seton_develops.setonretrofitdemo.model.TypicodeData
import com.seton_develops.setonretrofitdemo.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val responseData: MutableLiveData<Response<TypicodeData>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response: Response<TypicodeData> = repository.getPost()
            responseData.value = response
        }
    }

    fun getSpecificPost(id:Long) {
        viewModelScope.launch {
            val response: Response<TypicodeData> = repository.getSpecificPost(id)
            responseData.value = response
        }

    }
}
package com.example.finalassigment.network


import com.example.finalassigment.data.Science
import com.example.finalassigment.data.ScienceResponse
import retrofit2.http.GET
import retrofit2.Call

interface ScienceApi {
    @GET("dashboard/science")
    fun getScience(): Call<ScienceResponse>

}
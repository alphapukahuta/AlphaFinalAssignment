package com.example.finalassigment.network

// Import necessary data models and Retrofit annotations
import com.example.finalassigment.data.Science
import com.example.finalassigment.data.ScienceResponse
import retrofit2.http.GET
import retrofit2.Call

// An interface for making network requests related to science data.
interface ScienceApi {
    // A GET request to fetch a list of science entities from the server.
    @GET("dashboard/science")
    fun getScience(): Call<ScienceResponse>
}

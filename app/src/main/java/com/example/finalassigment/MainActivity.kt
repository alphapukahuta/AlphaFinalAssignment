package com.example.finalassigment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.finalassigment.network.RetrofitInstance
import com.example.finalassigment.data.ScienceResponse


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var scienceAdapter: ScienceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from API
        fetchSportsData()
    }

    private fun fetchSportsData() {
        RetrofitInstance.api.getScience().enqueue(object : Callback<ScienceResponse> {
            override fun onResponse(call: Call<ScienceResponse>, response: Response<ScienceResponse>) {
                if (response.isSuccessful) {
                    val scienceList = response.body()?.entities
                    scienceList?.let {
                        // Set up the adapter with the retrieved data
                        scienceAdapter = ScienceAdapter(it)
                        recyclerView.adapter = scienceAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ScienceResponse>, t: Throwable) {
                // Handle error
            }
        })
    }
}
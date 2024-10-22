package com.example.finalassigment

// Import necessary Android and Retrofit components
import androidx.appcompat.app.AppCompatActivity  // Base class for Android activities
import android.os.Bundle  // For passing data between components
import android.widget.Toast  // To show brief messages to the user
import androidx.recyclerview.widget.LinearLayoutManager  // Manages the layout for RecyclerView
import androidx.recyclerview.widget.RecyclerView  // Displays lists efficiently
import retrofit2.Call  // Represents a network request
import retrofit2.Callback  // Handles asynchronous responses
import retrofit2.Response  // Represents the response from an API call
import com.example.finalassigment.network.RetrofitInstance  // Singleton Retrofit instance
import com.example.finalassigment.data.ScienceResponse  // Model for the API response

// MainActivity manages the display of science-related data fetched from the API.
class MainActivity : AppCompatActivity() {

    // Declare RecyclerView and Adapter to manage and display a list of items.
    private lateinit var recyclerView: RecyclerView
    private lateinit var scienceAdapter: ScienceAdapter  // Custom adapter for RecyclerView

    // onCreate() is called when the activity is created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Set the UI layout for the activity

        // Initialize RecyclerView from the layout file
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)  // Set a vertical list layout

        // Fetch the data from the API and display it in the RecyclerView
        fetchScienceData()
    }

    // Function to fetch data from the API using Retrofit
    private fun fetchScienceData() {
        // Use Retrofit instance to call the getScience() method asynchronously
        RetrofitInstance.api.getScience().enqueue(object : Callback<ScienceResponse> {

            // Called when the API call is successful
            override fun onResponse(
                call: Call<ScienceResponse>,
                response: Response<ScienceResponse>
            ) {
                if (response.isSuccessful) {  // Check if the response status is 2xx
                    val scienceList = response.body()?.entities  // Extract the list of entities

                    // If the list is not null, set up the RecyclerView with the adapter
                    scienceList?.let {
                        scienceAdapter = ScienceAdapter(it)  // Initialize the adapter with data
                        recyclerView.adapter = scienceAdapter  // Attach the adapter to RecyclerView
                    }
                }
            }

            // Called when the API call fails (e.g., network issue)
            override fun onFailure(call: Call<ScienceResponse>, t: Throwable) {
                // Show a toast message indicating the error
                Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

package com.example.finalassigment.network

// Import necessary Retrofit components
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// This object ensures we create a single instance (singleton) of Retrofit throughout the app.
object RetrofitInstance {

    // 'retrofit' is a lazy-initialized Retrofit instance.
    // Lazy initialization means it will only be created when it is first accessed.
    private val retrofit by lazy {
        Retrofit.Builder()  // Use the Builder to configure the Retrofit instance.
            .baseUrl("https://nit3213-api-h2b3-latest.onrender.com/")  // Set the base API URL.
            .addConverterFactory(GsonConverterFactory.create())  // Use Gson to convert JSON responses to data models.
            .build()  // Build the Retrofit instance.
    }

    // 'api' is a lazy-initialized instance of the ScienceApi service.
    // This provides access to the API methods defined in the ScienceApi interface.
    val api: ScienceApi by lazy {
        retrofit.create(ScienceApi::class.java)  // Create the ScienceApi service.
    }
}

package com.example.finalassigment

// Import necessary Android and OkHttp libraries
import android.content.Intent  // For launching other activities
import android.os.Bundle  // For passing data between Android components
import android.widget.Button  // Button UI component
import android.widget.EditText  // Text input component for username and password
import android.widget.Toast  // For displaying brief messages to the user
import androidx.appcompat.app.AppCompatActivity  // Base class for Android activities
import okhttp3.*  // OkHttp classes for making HTTP requests
import okhttp3.MediaType.Companion.toMediaType  // Extension for setting media type
import okhttp3.RequestBody.Companion.toRequestBody  // Extension to convert JSON to RequestBody
import org.json.JSONObject  // For creating JSON objects
import java.io.IOException  // Handle input-output exceptions

// LoginActivity handles user authentication using a network request.
class LoginActivity : AppCompatActivity() {

    // Declare EditText and Button variables to reference UI components.
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    // Create an instance of OkHttpClient to handle network requests.
    private val client = OkHttpClient()

    // The onCreate() method is called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)  // Set the UI layout for this activity.

        // Initialize UI components by linking them to their respective views.
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        // Set an onClickListener for the login button to trigger login attempts.
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()  // Get the username input.
            val password = etPassword.text.toString()  // Get the password input.

            // Check if both fields are filled before attempting login.
            if (username.isNotEmpty() && password.isNotEmpty()) {
                login(username, password)  // Call the login function with the entered credentials.
            } else {
                // Show a toast message if either field is empty.
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // login() sends a POST request to the server to authenticate the user.
    private fun login(username: String, password: String) {
        val url = "https://nit3213-api-h2b3-latest.onrender.com/footscray/auth"  // API endpoint URL.

        // Create a JSON object with the username and password.
        val jsonObject = JSONObject().apply {
            put("username", username)  // Add the username field.
            put("password", password)  // Add the password field.
        }

        // Convert the JSON object to a request body with the appropriate media type.
        val requestBody = jsonObject.toString().toRequestBody("application/json".toMediaType())

        // Build the HTTP POST request using OkHttp.
        val request = Request.Builder()
            .url(url)  // Set the URL of the request.
            .post(requestBody)  // Set the request method to POST with the request body.
            .build()

        // Execute the request asynchronously to avoid blocking the main thread.
        client.newCall(request).enqueue(object : Callback {
            // Handle network or request failures.
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    // Show a toast message indicating a network error.
                    Toast.makeText(this@LoginActivity, "Network Error", Toast.LENGTH_SHORT).show()
                }
            }

            // Handle the server's response.
            override fun onResponse(call: Call, response: Response) {
                runOnUiThread {
                    if (response.isSuccessful) {  // Check if the response was successful (HTTP 2xx).
                        // Launch the MainActivity if login is successful.
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)  // Start the new activity.
                        finish()  // Close the LoginActivity.
                    } else {
                        // Show a toast message if the credentials are invalid.
                        Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}

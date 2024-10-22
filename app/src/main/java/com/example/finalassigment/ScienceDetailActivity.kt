package com.example.finalassigment

// Import necessary Android components
import android.annotation.SuppressLint  // For suppressing lint warnings
import android.os.Bundle  // For passing data between Android components
import android.view.View  // Represents UI components in Android
import androidx.appcompat.app.AppCompatActivity  // Base class for activities
import android.widget.TextView  // For displaying text in the UI

// Activity to display detailed information about a science topic.
class ScienceDetailActivity : AppCompatActivity() {

    // Declare TextView variables for each piece of science data
    private lateinit var tvfield: TextView
    private lateinit var tvconcept: TextView
    private lateinit var tvscientist: TextView
    private lateinit var tvyearProposed: TextView
    private lateinit var tvbranch: TextView
    private lateinit var tvdescription: TextView

    // onCreate() is called when the activity is created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science_detail)  // Set the activity's layout

        // Initialize the TextView components by linking them to their respective views in the layout
        tvfield = findViewById(R.id.tvfield)
        tvconcept = findViewById(R.id.tvconcept)
        tvscientist = findViewById(R.id.tvscientist)
        tvyearProposed = findViewById(R.id.tvyearProposed)
        tvbranch = findViewById(R.id.tvbranch)
        tvdescription = findViewById(R.id.tvdescription)

        // Retrieve data passed from the previous activity through the Intent
        val field = intent.getStringExtra("field") ?: "no field"  // Default to "no field" if not found
        val concept = intent.getStringExtra("concept") ?: "no concept"  // Default to "no concept"
        val scientist = intent.getStringExtra("scientist") ?: "Unknown scientist"  // Default to "Unknown scientist"
        val yearProposed = intent.getIntExtra("year proposed", 0)  // Default to 0 if not found
        val branch = intent.getStringExtra("branch") ?: "no branch"  // Default to "no branch"
        val description = intent.getStringExtra("description") ?: "No description"  // Default if empty

        // Set the retrieved data into the appropriate TextViews for display
        tvfield.text = "Field: $field"
        tvconcept.text = "Concept: $concept"
        tvscientist.text = "Scientist: $scientist"
        tvyearProposed.text = "Year Proposed: $yearProposed"
        tvbranch.text = "Branch: $branch"
        tvdescription.text = "Description: $description"
    }

    // Function to navigate back to the previous activity (dashboard).
    fun goBackToDashboard(view: View) {
        finish()  // Close this activity and return to the previous one.
    }
}

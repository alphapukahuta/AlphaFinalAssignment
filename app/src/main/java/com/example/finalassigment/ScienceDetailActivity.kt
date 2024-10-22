package com.example.finalassigment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ScienceDetailActivity: AppCompatActivity() {

    private lateinit var tvfield: TextView
    private lateinit var tvconcept: TextView
    private lateinit var tvscientist: TextView
    private lateinit var tvyearProposed: TextView
    private lateinit var tvbranch: TextView
    private lateinit var tvdescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science_detail)

        // Initialize views
        tvfield = findViewById(R.id.tvfield)
        tvconcept = findViewById(R.id.tvconcept)
        tvscientist = findViewById(R.id.tvscientist)
        tvyearProposed = findViewById(R.id.tvyearProposed)
        tvbranch = findViewById(R.id.tvbranch)
        tvdescription = findViewById(R.id.tvdescription)


        // Retrieve the data from the intent
        val field = intent.getStringExtra("field") ?: "no field"
        val concept = intent.getStringExtra("concept") ?: "no concept"
        val scientist = intent.getStringExtra("scientist") ?: "Unknown scientist"
        val yearProposed = intent.getIntExtra("year proposed", 0)
        val branch = intent.getStringExtra("branch") ?:"no branch"
        val description = intent.getStringExtra("description") ?: "No description"

        // Set the data to the TextViews
        tvfield.text = "Field: $field"
        tvconcept.text = "Concept: $concept"
        tvscientist.text = "Scientist: $scientist"
        tvyearProposed.text = "Year Proposed: $yearProposed"
        tvbranch.text = "Branch: $branch"
        tvdescription.text = "Description: $description"


    }



    fun goBackToDashboard(view: View) {
        finish()
    }
}
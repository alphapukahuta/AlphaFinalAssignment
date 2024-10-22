package com.example.finalassigment.data

// A data class to represent a science
data class Science(
    val field: String,           // The category or area of science.
    val concept: String,         // The main idea or topic.
    val scientist: String,       // Name of the person associated with it.
    val yearProposed: Int,       // Year the idea was introduced.
    val branch: String,          // Sub-area within the field.
    val description: String      // A short explanation or summary.
)

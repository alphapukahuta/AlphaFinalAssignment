package com.example.finalassigment.data

// A data class to represent a response containing multiple science entities.
data class ScienceResponse(
    val entities: List<Science>,  // A list of science-related items.
    val entityTotal: Int           // Total number of entities in the response.
)

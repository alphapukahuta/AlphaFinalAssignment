Science Dashboard Android App

Overview
The Science Subjects App allows users to log in with their credentials and explore a list of science topics, each with relevant information such as the concept, scientist, year proposed, and scientific branch. Users can click on a specific subject to view more details about it.

Features
User Authentication: Users can log in via a login screen.
List of Science Subjects: Displays a list of science topics fetched from a REST API.
Detailed View for Each Subject: Shows additional information about each topic, including the concept, scientist, and description.
Easy Navigation: Seamless navigation between the main dashboard and detailed views.

Requirements
- Android Studio
- Hilt library
- Retrofit2 (used for communication with the API to obtain data)

To install retrofit and hilt, enter this into android studios

// Core Retrofit dependencies
implementation("com.squareup.retrofit2:retrofit:2.11.0")
implementation("com.squareup.retrofit2:converter-gson:2.11.0")
implementation("com.squareup.retrofit2:converter-moshi:2.11.0")

// Gson and Moshi for JSON parsing
implementation("com.google.code.gson:gson:2.11.0")
implementation("com.squareup.moshi:moshi-kotlin:1.15.1")

// OkHttp logging interceptor for network debugging
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

// Hilt dependancies
implementation("com.google.dagger:hilt-android:2.52")
implementation(libs.androidx.recyclerview)

Follow these steps to get the project running

1. Obtain the base url

2. Intall Hilt and Retrofit

4. Input the API url and endpoints

3. Run the application

4. input the correct coredentials

package com.example.finalassigment

import org.junit.Assert.*  // Import assertions
import org.junit.Before  // Import @Before for setup
import org.junit.Test  // Import @Test for tests

class RegisterNewUsers {
    // Function to verify user details
    fun Verifynewusers(username: String, password: String): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            return false
        }
        return true  // Return true if both username and password are valid
    }
}


class LoginActivityTest {

    private lateinit var registerNewUsers: RegisterNewUsers  // Declare the class instance

    @Before
    fun setup() {
        // Initialize the RegisterNewUsers instance before each test
        registerNewUsers = RegisterNewUsers()
    }

    @Test
    fun `empty username returns false`() {
        val result = registerNewUsers.Verifynewusers(
            username = "",
            password = "password123"
        )
        assertFalse(result)  // Assert that the result is false
    }

    @Test
    fun `empty password returns false`() {
        val result = registerNewUsers.Verifynewusers(
            username = "testuser",
            password = ""
        )
        assertFalse(result)  // Assert that the result is false
    }

}

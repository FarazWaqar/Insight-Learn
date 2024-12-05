package com.example.insightlearn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    // A temporary storage for user credentials (email -> password)
    companion object {
        val userDatabase = HashMap<String, String>() // Email -> Password
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_screen)

        // Find views
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val ageInput = findViewById<EditText>(R.id.ageInput)
        val genderInput = findViewById<EditText>(R.id.genderInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val reenterPasswordInput = findViewById<EditText>(R.id.reenterPasswordInput)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpButton.setOnClickListener {
            val name = nameInput.text.toString()
            val age = ageInput.text.toString()
            val gender = genderInput.text.toString()
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val reenterPassword = reenterPasswordInput.text.toString()

            // Validation
            if (name.isEmpty() || age.isEmpty() || gender.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != reenterPassword) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save user credentials
            if (userDatabase.containsKey(email)) {
                Toast.makeText(this, "User already exists!", Toast.LENGTH_SHORT).show()
            } else {
                userDatabase[email] = password
                Toast.makeText(this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show()

                // Navigate to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}

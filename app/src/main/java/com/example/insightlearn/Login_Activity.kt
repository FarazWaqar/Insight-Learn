package com.example.insightlearn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        // Find views
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()





            // Validate login credentials
            if (SignUpActivity.userDatabase.containsKey(email) && SignUpActivity.userDatabase[email] == password) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                // Navigate to HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password!", Toast.LENGTH_SHORT).show()
            }


        }

        // Navigate to SignUpActivity
        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}

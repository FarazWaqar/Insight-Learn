package com.example.insightlearn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class graphActivityResult : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graphresult_screen)

        // Get Results Passed from GraphDetection_Activity
        val results = intent.getStringExtra("results")  // Use the same key "results"

        // Display Results
        val resultTextView = findViewById<TextView>(R.id.resultText)
        resultTextView.text = results

        // Back Button to Go to GraphDetection_Activity
        val backButton = findViewById<Button>(R.id.backButtonResult)
        backButton.setOnClickListener {
            val intent = Intent(this, GraphDetection_Activity::class.java)
            startActivity(intent)
            finish()
        }

        // Home Button Click Listener
        val homeButton = findViewById<ImageButton>(R.id.homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        /*
        // Settings Button Click Listener
        val settingsButton = findViewById<ImageButton>(R.id.settingsButton)
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }

         */
    }
}

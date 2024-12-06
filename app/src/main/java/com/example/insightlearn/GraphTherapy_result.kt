package com.example.insightlearn

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class graphtherapyresult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graphtherapy_result)

        // Get results passed from UnscrambleActivity
        val results = intent.getStringArrayListExtra("results")

        // Display results
        val resultsText = findViewById<TextView>(R.id.resultsText)
        resultsText.text = results?.joinToString("\n") { it }

        // Back button to return to main screen
        val backButton = findViewById<Button>(R.id.backButtonResult)
        backButton.setOnClickListener {
            finish()
        }
    }
}



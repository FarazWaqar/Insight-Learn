package com.example.insightlearn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class graphtherapyresultactivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graphtherapy_result)

        val resultsTextView = findViewById<TextView>(R.id.resultText)
        val correctInputsTextView = findViewById<TextView>(R.id.correctInputText)

        val results = intent.getStringArrayListExtra("results")



        if (results != null && results.isNotEmpty()) {
            val correctResults = results.filter { it.contains("Correct") }
            val wrongResults = results.filter { it.contains("Wrong") }

            val correctCount = correctResults.size
            val wrongCount = wrongResults.size

            // Display the count of correct and wrong inputs
            resultsTextView.text = "Correct: $correctCount\nWrong: $wrongCount"

            // Display all correct answers
            val correctAnswers = correctResults.joinToString("\n")
            correctInputsTextView.text = "Correct Inputs:\n$correctAnswers"
        } else {
            resultsTextView.text = "No answers provided or all answers were incorrect."
            correctInputsTextView.text = ""
        }

        // Home Button functionality
        val homeButton = findViewById<Button>(R.id.homeButtonResult)
        homeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        /*

        // Settings Button functionality
        val settingsButton = findViewById<Button>(R.id.settingsButtonResult)
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

         */
    }
}


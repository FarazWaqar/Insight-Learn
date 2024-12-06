package com.example.insightlearn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class graphActivityResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graphresult_screen)

        // Get Results Passed from GraphDetection_Activity
        val results = intent.getStringExtra("results")  // Use the same key "results"

        // Display Results
        val resultTextView = findViewById<TextView>(R.id.resultText)
        resultTextView.text = results

        // Back Button to Go to Main Activity
        val backButton = findViewById<Button>(R.id.backButtonResult)
        backButton.setOnClickListener {
            val intent = Intent(this, GraphDetection_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

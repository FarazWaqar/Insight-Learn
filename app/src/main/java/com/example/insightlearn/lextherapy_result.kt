package com.example.insightlearn

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class lexthearpyresult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lextherapy_result)

        // Get the score passed from the previous activity
        val score = intent.getIntExtra("score", 0)

        // Find the TextView and set the score text
        val scoreText: TextView = findViewById(R.id.score_text)
        scoreText.text = "Score: $score"
    }
}

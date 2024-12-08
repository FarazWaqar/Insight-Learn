package com.example.insightlearn

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class graphtherapyresult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graphtherapy_result)

        val resultTextView = findViewById<TextView>(R.id.resultText)
        val results = intent.getStringArrayListExtra("results")

        if (results != null && results.isNotEmpty()) {
            val resultText = "Results:\n" + results.joinToString("\n")
            resultTextView.text = resultText
        } else {
            resultTextView.text = "No results to display."
        }
    }
}



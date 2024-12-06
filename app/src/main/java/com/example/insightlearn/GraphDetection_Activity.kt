package com.example.insightlearn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GraphDetection_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graph_detection_screen)

        // Inputs
        val inputHen = findViewById<EditText>(R.id.inputHen)
        val inputBag = findViewById<EditText>(R.id.inputBag)
        val inputHat = findViewById<EditText>(R.id.inputHat)
        val inputSun = findViewById<EditText>(R.id.inputSun)

        // Buttons
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            // Validate Inputs
            if (inputHen.text.isNullOrEmpty() || inputBag.text.isNullOrEmpty() ||
                inputHat.text.isNullOrEmpty() || inputSun.text.isNullOrEmpty()
            ) {
                // Alert if fields are empty
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check Answers
            val henAnswer = inputHen.text.toString().lowercase()
            val bagAnswer = inputBag.text.toString().lowercase()
            val hatAnswer = inputHat.text.toString().lowercase()
            val sunAnswer = inputSun.text.toString().lowercase()

            var results = ""
            var correctCount = 0

            if (henAnswer == "n") {
                results += "Hen: Correct\n"
                correctCount++
            } else {
                results += "Hen: Wrong\n"
            }

            if (bagAnswer == "a") {
                results += "Bag: Correct\n"
                correctCount++
            } else {
                results += "Bag: Wrong\n"
            }

            if (hatAnswer == "t") {
                results += "Hat: Correct\n"
                correctCount++
            } else {
                results += "Hat: Wrong\n"
            }

            if (sunAnswer == "u") {
                results += "Sun: Correct\n"
                correctCount++
            } else {
                results += "Sun: Wrong\n"
            }

            results = "Score: $correctCount/4\n\n$results"

            // Pass Results to graphActivityResult
            val intent = Intent(this, graphActivityResult::class.java)
            intent.putExtra("results", results)
            startActivity(intent)
        }
    }
}

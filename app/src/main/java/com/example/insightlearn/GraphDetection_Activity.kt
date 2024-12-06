package com.example.insightlearn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
            // Check Answers
            val henAnswer = inputHen.text.toString()
            val bagAnswer = inputBag.text.toString()
            val hatAnswer = inputHat.text.toString()
            val sunAnswer = inputSun.text.toString()

            var resultMessage = ""

            resultMessage += if (henAnswer == "n") "Hen: Correct\n" else "Hen: Wrong\n"
            resultMessage += if (bagAnswer == "a") "Bag: Correct\n" else "Bag: Wrong\n"
            resultMessage += if (hatAnswer == "t") "Hat: Correct\n" else "Hat: Wrong\n"
            resultMessage += if (sunAnswer == "u") "Sun: Correct\n" else "Sun: Wrong\n"

            // Navigate to Result Screen
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("resultMessage", resultMessage)
            startActivity(intent)
        }
    }
}

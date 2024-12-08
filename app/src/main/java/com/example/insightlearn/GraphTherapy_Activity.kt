package com.example.insightlearn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class graphtherapy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graphtherapy)

        val inputFields = listOf(
            findViewById<EditText>(R.id.input1),
            findViewById<EditText>(R.id.input2),
            findViewById<EditText>(R.id.input3),
            findViewById<EditText>(R.id.input4),
            findViewById<EditText>(R.id.input5),
            findViewById<EditText>(R.id.input6),
            findViewById<EditText>(R.id.input7),
            findViewById<EditText>(R.id.input8),
            findViewById<EditText>(R.id.input9)
        )

        val correctAnswers = listOf("AUNT", "SON", "UNCLE", "SISTER", "MOTHER", "FATHER", "BROTHER", "GRANDPA", "GRANDMA")

        val nextButton = findViewById<Button>(R.id.checkAnswersButton)
        nextButton.setOnClickListener {
            // Convert user inputs to uppercase for comparison
            val userAnswers = inputFields.map { it.text.toString().trim().uppercase() }

            // Get the results only for non-empty inputs
            val results = userAnswers.mapIndexedNotNull { index, answer ->
                if (answer.isNotEmpty()) {
                    if (answer == correctAnswers[index].uppercase()) {
                        index to "Correct"
                    } else {
                        index to "Wrong"
                    }
                } else {
                    null
                }
            }

            // Provide feedback for each input
            userAnswers.forEachIndexed { index, answer ->
                if (answer.isNotEmpty()) {
                    if (answer == correctAnswers[index].uppercase()) {
                        inputFields[index].setBackgroundResource(R.drawable.correct_input_background)
                    } else {
                        inputFields[index].setBackgroundResource(R.drawable.incorrect_input_background)
                    }
                }
            }

            // Check if any answers were correct or wrong and display appropriate messages
            if (results.isNotEmpty()) {
                val correctCount = results.count { it.second == "Correct" }
                val wrongCount = results.count { it.second == "Wrong" }

                // Display results
                if (wrongCount == 0) {
                    Toast.makeText(this, "All entered answers are correct!", Toast.LENGTH_SHORT).show()
                    navigateToResultActivity()
                } else {
                    Toast.makeText(this, "Some answers are incorrect. You got $correctCount correct and $wrongCount wrong.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Handle case when no input was provided
                Toast.makeText(this, "No answers provided. Please enter some text.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }
}

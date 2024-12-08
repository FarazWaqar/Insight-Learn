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
            // Convert user inputs and correct answers to uppercase for uniform comparison
            val userAnswers = inputFields.map { it.text.toString().trim().uppercase() }
            val correctAnswers = listOf("AUNT", "SON", "UNCLE", "SISTER", "MOTHER", "FATHER", "BROTHER", "GRANDPA", "GRANDMA")

            val results = userAnswers.mapIndexed { index, answer ->
                if (answer == correctAnswers[index].uppercase()) "Correct" else "Wrong"
            }

// Provide feedback to the user
            userAnswers.forEachIndexed { index, answer ->
                if (answer == correctAnswers[index].uppercase()) {
                    inputFields[index].setBackgroundResource(R.drawable.correct_input_background)
                } else {
                    inputFields[index].setBackgroundResource(R.drawable.incorrect_input_background)
                }
            }


            if (results.all { it == "Correct" }) {
                Toast.makeText(this, "All answers are correct!", Toast.LENGTH_SHORT).show()
                navigateToResultActivity()
            } else {
                Toast.makeText(this, "Some answers are incorrect. Try again!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToResultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }
}


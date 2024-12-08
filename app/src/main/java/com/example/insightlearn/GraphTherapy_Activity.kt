package com.example.insightlearn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class graphtherapyactivity : AppCompatActivity() {

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

        val correctAnswers = listOf(
            "AUNT",
            "SON",
            "UNCLE",
            "SISTER",
            "MOTHER",
            "FATHER",
            "BROTHER",
            "GRANDPA",
            "GRANDMA"
        )

            val nextButton = findViewById<Button>(R.id.checkAnswersButton)
            nextButton.setOnClickListener {
                Log.d("GraphTherapy", "Check Answers button clicked")
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

                // Navigate to the result activity, passing results data
                navigateToResultActivity(results)
            }
        }
    }
    private fun navigateToResultActivity(results: List<Pair<Int, String>>) {
        val intent = Intent(this@graphtherapyactivity, graphtherapyresultactivity::class.java)
        val resultDetails = results.map { "Input ${it.first + 1}: ${it.second}" }
        intent.putStringArrayListExtra("results", ArrayList(resultDetails))
        startActivity(intent)
    }


}



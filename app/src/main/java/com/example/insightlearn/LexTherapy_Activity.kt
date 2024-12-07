package com.example.insightlearn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class lextherapy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lex_therapy)

        // Set onClickListener for the "Next" button
        findViewById<View>(R.id.btn_next).setOnClickListener {
            checkAnswers()
        }
    }

    private fun checkAnswers() {
        var score = 0

        // Group 1 (Spring Image)
        val group1 = findViewById<RadioGroup>(R.id.group1)
        val selected1 = group1.checkedRadioButtonId
        if (selected1 == R.id.radio_spring_1) {
            score++
        }

        // Group 2 (Autumn Image)
        val group2 = findViewById<RadioGroup>(R.id.group2)
        val selected2 = group2.checkedRadioButtonId
        if (selected2 == R.id.radio_autumn_2) {
            score++
        }

        // Group 3 (Winter Image)
        val group3 = findViewById<RadioGroup>(R.id.group3)
        val selected3 = group3.checkedRadioButtonId
        if (selected3 == R.id.radio_winter_3) {
            score++
        }

        // Group 4 (Summer Image)
        val group4 = findViewById<RadioGroup>(R.id.group4)
        val selected4 = group4.checkedRadioButtonId
        if (selected4 == R.id.radio_summer_4) {
            score++
        }

        // Navigate to result screen
        val intent = Intent(this@lextherapy, ResultActivity::class.java)
        intent.putExtra("score", score)
        startActivity(intent)
    }
}

package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlin.reflect.typeOf

// QCMActivity.kt
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QCMActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qcm)

        val qcmName = intent.getStringExtra("qcm_name")
        title = qcmName

        val questionTextView = findViewById<TextView>(R.id.questionTextView)
        val answerButtons = listOf<Button>(
            findViewById(R.id.answerButton1),
            findViewById(R.id.answerButton2),
            findViewById(R.id.answerButton3),
            findViewById(R.id.answerButton4)
        )

        // You can set your questions and answers here
        val question = "What is the capital of France?"
        val answers = listOf("Paris", "Berlin", "London", "Madrid")
        questionTextView.text = question
        for ((index, answer) in answers.withIndex()) {
            answerButtons[index].text = answer
            answerButtons[index].setOnClickListener {
                if (answer == "Paris") {
                    showResult("Correct!")
                } else {
                    showResult("Incorrect!")
                }
            }
        }
    }

    private fun showResult(message: String) {
        setContentView(R.layout.activity_result)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = message

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}

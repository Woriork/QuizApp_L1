package com.example.quizapp_l1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp_l1.com.example.quizapp_l1.QuizRepository

class MainActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var questionHeader: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var answerGroup: RadioGroup
    lateinit var nextButton: Button
    lateinit var resultText: TextView
    lateinit var retryButton: Button

    var currentQuestionIndex = 0
    var score = 0
    val questions = QuizRepository.questionList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Przypisanie elementów interfejsu
        questionText = findViewById(R.id.questionText)
        questionHeader = findViewById(R.id.questionHeader)
        progressBar = findViewById(R.id.progressBar)
        answerGroup = findViewById(R.id.answerGroup)
        nextButton = findViewById(R.id.nextButton)
        resultText = findViewById(R.id.resultText)
        retryButton = findViewById(R.id.retryButton)

        // Wyświetlenie pierwszego pytania
        displayQuestion()

        // Obsługa kliknięcia przycisku „Następne”
        nextButton.setOnClickListener {
            checkAnswer() // Sprawdzenie odpowiedzi przed przejściem do następnego pytania

            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                displayQuestion()
            } else {
                displayResult() // Wyświetlenie wyniku po zakończeniu quizu
            }
        }

        // Obsługa kliknięcia przycisku „Zagraj jeszcze raz”
        retryButton.setOnClickListener {
            resetQuiz() // Funkcja resetująca quiz
        }
    }

    private fun displayQuestion() {
        val question = questions[currentQuestionIndex]
        questionText.text = question.questionText
        questionHeader.text = "Pytanie ${currentQuestionIndex + 1}/${questions.size}"
        progressBar.progress = ((currentQuestionIndex + 1).toFloat() / questions.size * 100).toInt()
        answerGroup.clearCheck()

        // Ustawienie tekstu dla każdego z przycisków RadioButton
        (answerGroup.getChildAt(0) as RadioButton).text = question.options[0]
        (answerGroup.getChildAt(1) as RadioButton).text = question.options[1]
        (answerGroup.getChildAt(2) as RadioButton).text = question.options[2]
        (answerGroup.getChildAt(3) as RadioButton).text = question.options[3]

        // Ustawienie widoczności przycisków
        resultText.visibility = View.GONE
        retryButton.visibility = View.GONE
        nextButton.visibility = View.VISIBLE
        questionText.visibility = View.VISIBLE
        answerGroup.visibility = View.VISIBLE
        questionHeader.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE
    }

    private fun checkAnswer() {
        val selectedOptionId = answerGroup.checkedRadioButtonId
        if (selectedOptionId != -1) {
            val selectedIndex = answerGroup.indexOfChild(findViewById(selectedOptionId))
            val correctAnswerIndex = questions[currentQuestionIndex].correctAnswerIndex
            if (selectedIndex == correctAnswerIndex) {
                score++
            }
        }
    }

    private fun displayResult() {
        questionText.visibility = View.GONE
        answerGroup.visibility = View.GONE
        nextButton.visibility = View.GONE
        questionHeader.visibility = View.GONE
        progressBar.visibility = View.GONE

        resultText.visibility = View.VISIBLE // Wyświetlenie wyniku
        resultText.text = "Twój wynik: $score/${questions.size} punktów"
        retryButton.visibility = View.VISIBLE // Wyświetlenie przycisku „Zagraj jeszcze raz”
    }

    private fun resetQuiz() {
        score = 0
        currentQuestionIndex = 0
        displayQuestion() // Wyświetlenie pierwszego pytania od nowa
    }
}

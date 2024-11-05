package com.example.quizapp_l1

data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
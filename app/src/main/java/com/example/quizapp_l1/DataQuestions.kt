package com.example.quizapp_l1.com.example.quizapp_l1

import com.example.quizapp_l1.Question

object QuizRepository {
    val questionList = listOf(
        Question(
            questionText = "Jaka jest jednostka prędkości w układzie SI?",
            options = listOf("m/s", "km/h", "m2", "s2"),
            correctAnswerIndex = 0
        ),
        Question(
            questionText = "Która planeta jest najbliżej Słońca?",
            options = listOf("Mars", "Ziemia", "Merkury", "Wenus"),
            correctAnswerIndex = 2
        ),
        Question(
            questionText = "Jaki jest symbol chemiczny dla wody?",
            options = listOf("CO2", "H2O", "O2", "NaCl"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "Ile godzin ma doba?",
            options = listOf("12", "24", "36", "48"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "Jakie jest największe jezioro na świecie?",
            options = listOf("Jezioro Bodeńskie", "Morze Kaspijskie", "Jezioro Wiktorii", "Jezioro Bałchasz"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "Kto napisał 'Pana Tadeusza'?",
            options = listOf("Juliusz Słowacki", "Adam Mickiewicz", "Bolesław Prus", "Henryk Sienkiewicz"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "Który gaz dominuje w atmosferze ziemskiej?",
            options = listOf("Tlen", "Azot", "Dwutlenek węgla", "Hel"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "W którym roku Polska odzyskała niepodległość?",
            options = listOf("1914", "1918", "1920", "1939"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "Ile nóg ma pająk?",
            options = listOf("6", "8", "10", "12"),
            correctAnswerIndex = 1
        ),
        Question(
            questionText = "Jaka jest wartość liczby Pi (w przybliżeniu)?",
            options = listOf("3.14", "2.72", "1.62", "4.20"),
            correctAnswerIndex = 0
        ),
        Question(
        questionText = "Jak nazywa się największy ssak na Ziemi?",
        options = listOf( "Płetwal błękitny","Tomek", "Orka", "Nosorożec"),
        correctAnswerIndex = 0
    )
    )

}



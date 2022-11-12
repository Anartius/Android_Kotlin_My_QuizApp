package com.example.myquizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions() : MutableList<Question> {

        val questionsList = mutableListOf<Question>()
        val askString = "What country does this flag belong to?"
        val que1 = Question(1, askString,
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia",
            "Armenia","Austria",
            1
        )
        questionsList.add(que1)

        val que2 = Question(2, askString,
            R.drawable.ic_flag_of_australia,
            "Angola","Austria",
            "Australia","Armenia",
            3
        )
        questionsList.add(que2)

        val que3 = Question(3, askString,
            R.drawable.ic_flag_of_brazil,
            "Belarus","Belize",
            "Brunei","Brazil",
            4
        )
        questionsList.add(que3)

        val que4 = Question(4, askString,
            R.drawable.ic_flag_of_belgium,
            "Bahamas","Belgium",
            "Barbados","Belize",
            2
        )
        questionsList.add(que4)

        val que5 = Question(5, askString,
            R.drawable.ic_flag_of_germany,
            "Germany","Georgia",
            "Greece","none of these",
            1
        )
        questionsList.add(que5)

        val que6 = Question(6, askString,
            R.drawable.ic_flag_of_fiji,
            "Gabon","France",
            "Fiji","Finland",
            3
        )
        questionsList.add(que6)

        val que7 = Question(7, askString,
            R.drawable.ic_flag_of_denmark,
            "Dominika","Egypt",
            "Denmark","Ethiopia",
            3
        )
        questionsList.add(que7)

        val que8 = Question(8, askString,
            R.drawable.ic_flag_of_india,
            "Ireland","Iran",
            "Hungary","India",
            4
        )
        questionsList.add(que8)

        val que9 = Question(9, askString,
            R.drawable.ic_flag_of_new_zealand,
            "New Zeeland","Jordan",
            "Sudan","Palestine",
            1
        )
        questionsList.add(que9)

        return questionsList
    }
}
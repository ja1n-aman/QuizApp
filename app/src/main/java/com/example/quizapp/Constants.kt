package com.example.quizapp

object Constants {

    var USER_NAME:String = "user_name"
    var TOTAL_QUES:String = "total_ques"
    var CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions():ArrayList<Ques>{
        val questionList = ArrayList<Ques>()

        val ques1 = Ques(
            1,
            "Which animal is in picture given below?",
            R.drawable.panda,
            "Panda",
            "Bear",
            "Koala",
            "Cat",
            1,
            )
        questionList.add(ques1)

        val ques2 = Ques(
            1,
            "Which animal is in picture given below?",
            R.drawable.penguin,
            "Panda",
            "Bear",
            "Koala",
            "Penguin",
            4,
        )
        questionList.add(ques2)

        val ques3 = Ques(
            1,
            "Which animal is in picture given below?",
            R.drawable.koala,
            "Panda",
            "Penguin",
            "Koala",
            "Cat",
            3,
        )
        questionList.add(ques3)

        val ques4 = Ques(
            1,
            "Which animal is in picture given below?",
            R.drawable.tiger,
            "Panda",
            "Bear",
            "Koala",
            "Tiger",
            4,
        )
        questionList.add(ques4)

        val ques5 = Ques(
            1,
            "Which animal is in picture given below?",
            R.drawable.giaraff,
            "Panda",
            "Giraff",
            "Koala",
            "Tiger",
            2,
        )
        questionList.add(ques5)



        return questionList
    }


}
package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnFinish:Button = findViewById(R.id.btnFinish)
        var tvName:TextView = findViewById(R.id.tvName)
        var tvResult:TextView = findViewById(R.id.tvResult)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val totalQUES = intent.getIntExtra(Constants.TOTAL_QUES,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvName.text = userName
        tvResult.text = "You got $correctAnswers correct out of $totalQUES "

        btnFinish.setOnClickListener(){
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}
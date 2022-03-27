package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

class QuizQuesActivity : AppCompatActivity() , View.OnClickListener {

    var currentPosition : Int = 1
    var questionList : ArrayList<Ques>? = null
    var selectedOption : Int? = null
    private var correctAnswer : Int = 0
    var userName : String? = null

    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null
    private var progressBar : ProgressBar? = null
    private var tvNo : TextView? = null
    private var opn1 : TextView? = null
    private var opn2 : TextView? = null
    private var opn3 : TextView? = null
    private var opn4 : TextView? = null
    var submitBtn : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ques)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        progressBar = findViewById(R.id.progressBar)
        tvNo = findViewById(R.id.tvNo)
        opn1 = findViewById(R.id.opn1)
        opn2 = findViewById(R.id.opn2)
        opn3 = findViewById(R.id.opn3)
        opn4 = findViewById(R.id.opn4)
        submitBtn = findViewById(R.id.submitBtn)
        opn1?.setOnClickListener(this)
        opn2?.setOnClickListener(this)
        opn3?.setOnClickListener(this)
        opn4?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)


        questionList = Constants.getQuestions()
        userName = intent.getStringExtra(Constants.USER_NAME)



        question()
        defaultOptionView()
    }

    private fun question() {

        defaultOptionView()
        val question: Ques = questionList!!.get(currentPosition-1)
        progressBar?.progress = currentPosition
        ivImage?.setImageResource(question.Image)
        tvNo?.text = "$currentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        opn1?.text = question.optionOne
        opn2?.text = question.optionTwo
        opn3?.text = question.optionThree
        opn4?.text = question.optionFour

        if(currentPosition == questionList!!.size){
            submitBtn?.text = "FINISH"
        }else{
            submitBtn?.text = "SUBMIT"
        }
    }
    fun defaultOptionView(){

        var options = ArrayList<TextView>()

        opn1?.let{
            options.add(0,it)
        }
        opn2?.let{
            options.add(1,it)
        }
        opn3?.let{
            options.add(2,it)
        }
        opn4?.let{
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#457B9D"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.opn_borde)
        }


    }

    fun selectedOptionView(tv:TextView,selectedOptionNo:Int){

        defaultOptionView()
        selectedOption = selectedOptionNo
        tv.setTextColor(Color.parseColor("#74c69d"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_border)
    }

    override fun onClick(view: View?) {

        when(view?.id){

            R.id.opn1 -> {
                opn1?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.opn2 -> {
                opn2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.opn3 -> {
                opn3?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.opn4 -> {
                opn4?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.submitBtn -> {

                if(selectedOption==0){
                    currentPosition++
                    when{currentPosition <= questionList!!.size -> {
                        question()
                    }
                        else -> {
                            val intent = Intent(this,Result::class.java)
                            intent.putExtra(Constants.USER_NAME,userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,correctAnswer)
                            intent.putExtra(Constants.TOTAL_QUES,questionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{


                    val question = questionList?.get(currentPosition-1)
                    if(selectedOption != question!!.correctAnswer){
                        setColor(selectedOption,R.drawable.red)
                    }else{
                        correctAnswer++
                    }
                    setColor(question.correctAnswer,R.drawable.green)

                    if(currentPosition == questionList!!.size){
                        submitBtn?.text = "FINISH"
                    }else{
                        submitBtn?.text = "GO TO NEXT QUESTION"
                    }

                    selectedOption=0
                }
            }
        }
    }

    fun setColor(ans:Int?,drawableView:Int){

        when(ans){

            1 -> {
                opn1?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                opn2?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                opn3?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                opn4?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }

    }
}
package com.example.myquizapp

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizActionsActivity : AppCompatActivity() {
    private var tvQuestion: TextView? = null
    private var ivFlag: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var btnSubmit: Button? = null

    private var userName: String? = null
    private var correctAnswers: Int = 0

    private var step = 0
    private val questionsList = Constants.getQuestions()
    private var currentOption = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_actions)

        tvQuestion = findViewById(R.id.tv_question)
        ivFlag = findViewById(R.id.iv_flag)
        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tv_progress)

        tvOption1 = findViewById(R.id.tv_option_one)
        tvOption2 = findViewById(R.id.tv_option_two)
        tvOption3 = findViewById(R.id.tv_option_three)
        tvOption4 = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        userName = intent.getStringExtra(Constants.USER_NAME)

        setValues()

        tvOption1?.setOnClickListener {
            currentOption = 1
            clearTvStyle()
            setTvStyle("selected", currentOption)
        }

        tvOption2?.setOnClickListener {
            currentOption = 2
            clearTvStyle()
            setTvStyle("selected", currentOption)
        }

        tvOption3?.setOnClickListener {
            currentOption = 3
            clearTvStyle()
            setTvStyle("selected", currentOption)
        }

        tvOption4?.setOnClickListener {
            currentOption = 4
            clearTvStyle()
            setTvStyle("selected", currentOption)
        }

        btnSubmit?.setOnClickListener {

            when (btnSubmit?.text) {
                "NEXT" -> {
                    step++
                    setValues()
                    currentOption = -1
                    clearTvStyle()
                    btnSubmit?.text = "SUBMIT"
                }

                "FINISH" -> {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, userName)
                    intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                    intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList.size)
                    startActivity(intent)
                    finish()
                }

                else -> {
                    if (currentOption > 0) {
                        if (currentOption == questionsList[step].correctAnswer) {
                            correctAnswers++
                        } else {
                            setTvStyle("wrong", currentOption)
                        }

                        setTvStyle("correct", questionsList[step].correctAnswer)
                        btnSubmit?.text = if (step < questionsList.size - 1) "NEXT" else "FINISH"

                    }
                }
            }
        }

    }

    private fun setValues() {
        tvQuestion?.text = questionsList[step].question
        ivFlag?.setImageResource(questionsList[step].image)
        progressBar?.progress = step + 1
        tvProgress?.text = "${step + 1}/${progressBar?.max}"
        tvOption1?.text = questionsList[step].optionOne
        tvOption2?.text = questionsList[step].optionTwo
        tvOption3?.text = questionsList[step].optionThree
        tvOption4?.text = questionsList[step].optionFour
    }


    private fun setTvStyle(tvStyle: String, option: Int) {
        val tvOptionsList = listOf(tvOption1, tvOption2, tvOption3, tvOption4)

        val tvStyleOption = when (tvStyle) {
            "selected" -> R.drawable.selected_option_border_bg
            "correct" -> R.drawable.correct_option_border_bg
            "wrong" -> R.drawable.wrong_option_border_bg
            else -> R.drawable.default_option_border_bg
        }

        tvOptionsList[option - 1]?.let {
            it.setBackgroundResource(tvStyleOption)
            it.setTextColor(ContextCompat.getColor(this, R.color.text_dark_grey))
            it.typeface = Typeface.DEFAULT_BOLD
        }
    }


    private fun clearTvStyle () {
        val tvOptionsList = listOf(tvOption1, tvOption2, tvOption3, tvOption4)

        tvOptionsList.forEach {
            it?.setBackgroundResource(R.drawable.default_option_border_bg)
            it?.setTextColor(ContextCompat.getColor(this, R.color.text_light_grey))
            it?.typeface = Typeface.DEFAULT
        }
    }
}
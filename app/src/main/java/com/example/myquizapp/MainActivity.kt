package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var btnStart: Button? = null
    var etName: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName= findViewById(R.id.et_name)
        btnStart = findViewById(R.id.btn_start)
        btnStart?.setOnClickListener {

            if (etName?.text?.isEmpty() == true) {
                Toast.makeText(this,
                    "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuizActionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName?.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
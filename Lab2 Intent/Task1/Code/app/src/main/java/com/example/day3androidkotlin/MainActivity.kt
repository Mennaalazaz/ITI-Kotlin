package com.example.day3androidkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etPhoneNumber: EditText = findViewById(R.id.etPhoneNumber)
        val etMessage: EditText = findViewById(R.id.etMessage)
        val btnClose: Button = findViewById(R.id.btnClose)
        val btnNext: Button = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            val phoneNumber = etPhoneNumber.text.toString()
            val message = etMessage.text.toString()

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("PHONE_NUMBER", phoneNumber)
                putExtra("MESSAGE", message)
            }
            startActivity(intent)
        }

        btnClose.setOnClickListener {
            finish()
        }

    }
}
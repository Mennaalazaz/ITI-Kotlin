package com.example.day3androidkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val tvPhoneNumber: TextView = findViewById(R.id.tvPhoneNumber)
        val tvMessage: TextView = findViewById(R.id.tvMessage)
        val btnClose: Button = findViewById(R.id.btnClose)

        val intent= getIntent()
        val phoneNumber = intent.getStringExtra("PHONE_NUMBER")
        val message = intent.getStringExtra("MESSAGE")

        tvPhoneNumber.text = phoneNumber
        tvMessage.text = message

        btnClose.setOnClickListener {
            finish()
        }
    }
}
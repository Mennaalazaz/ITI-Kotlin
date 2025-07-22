package com.example.lab6_sharedpreferances_localization

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextPhone: EditText
    private lateinit var editTextMessage: EditText
    private lateinit var buttonClose: Button
    private lateinit var buttonNext: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPhone = findViewById(R.id.editTextPhone)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonClose = findViewById(R.id.buttonClose)
        buttonNext = findViewById(R.id.buttonNext)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        buttonNext.setOnClickListener {
            val phone = editTextPhone.text.toString()
            val message = editTextMessage.text.toString()

            // To write to a shared preferences file, create a SharedPreferences.Editor by calling edit(). [3]
            val editor = sharedPreferences.edit()
            editor.putString("phone", phone)
            editor.putString("message", message)
            editor.apply()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        buttonClose.setOnClickListener {
            finish()
        }
    }
}
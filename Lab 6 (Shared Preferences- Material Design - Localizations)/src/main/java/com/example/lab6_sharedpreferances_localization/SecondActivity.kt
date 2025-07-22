package com.example.lab6_sharedpreferances_localization

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var textViewPhone: TextView
    private lateinit var textViewMessage: TextView
    private lateinit var buttonReadSPref: Button
    private lateinit var buttonWriteSPref: Button
    private lateinit var buttonClose: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textViewPhone = findViewById(R.id.textViewPhone)
        textViewMessage = findViewById(R.id.textViewMessage)
        buttonReadSPref = findViewById(R.id.buttonReadSPref)
        buttonWriteSPref = findViewById(R.id.buttonWriteSPref)
        buttonClose = findViewById(R.id.buttonClose)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        buttonReadSPref.setOnClickListener {
            // To retrieve values from a SharedPreferences file, provide the key and a default value.
            val phone = sharedPreferences.getString("phone", "No Phone Number")
            val message = sharedPreferences.getString("message", "No Message")

            textViewPhone.text = phone
            textViewMessage.text = message
        }

        buttonWriteSPref.setOnClickListener {
            textViewPhone.text = ""
            textViewMessage.text = ""
        }

        buttonClose.setOnClickListener {
            finish()
        }
    }
}
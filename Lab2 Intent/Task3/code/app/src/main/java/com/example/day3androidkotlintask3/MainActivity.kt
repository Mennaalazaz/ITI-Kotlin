package com.example.day3androidkotlintask3

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

     var rotationCount = 0
     lateinit var countTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Find the TextView from our layout.
        countTextView = findViewById(R.id.rotation_count_text)

        // Check if savedInstanceState is not null.
        // This will be true if the Activity is being recreated after a configuration change.
        if (savedInstanceState != null) {
            rotationCount = savedInstanceState.getInt("ROTATION_COUNT_KEY", 0)
        }

        countTextView.text = "Rotations: $rotationCount"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        rotationCount++
        // Save the new value of our counter into the outState Bundle.
        // The system will hold onto this Bundle and pass it back to onCreate.
        outState.putInt("ROTATION_COUNT_KEY", rotationCount)
    }

}
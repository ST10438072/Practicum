package com.example.myapplication.st10438072.practicum

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.st10438072.practicum.databinding.MainActivityBinding

class SplashActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        val startButton = findViewById<Button>(R.id.StartButton)
        val exitButton =findViewById<Button>(R.id.ExitButton)

        startButton.setOnClickListener{
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener{
            finish()
        }

    }
}

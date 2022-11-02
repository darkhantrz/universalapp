package com.example.universalapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class WeatherForecastActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_forecast)




        val goBackToMainActivity: ImageView = findViewById(R.id.goBackToMain)

        goBackToMainActivity.setOnClickListener {
            finish()
        }
    }
}
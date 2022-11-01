package com.example.universalapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bmiCalculatorCardView : CardView = findViewById(R.id.cardView1)
        bmiCalculatorCardView.setOnClickListener {
            openBmiCalculatorActivity()
        }
    }

    private fun openBmiCalculatorActivity() {
        val intent = Intent(this, BmiCalculatorActivity::class.java)
        startActivity(intent)
    }
}
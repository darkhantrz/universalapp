package com.example.universalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.bmi_calculator)
        btn.setOnClickListener {
            openBmiCalculatorActivity()
        }
    }

    private fun openBmiCalculatorActivity() {
        val intent = Intent(this, BmiCalculatorActivity::class.java)
        startActivity(intent)
    }
}
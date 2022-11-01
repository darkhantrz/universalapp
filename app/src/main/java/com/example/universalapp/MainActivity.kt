package com.example.universalapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.universalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmiCalculatorCardView : CardView = binding.cardView1
        bmiCalculatorCardView.setOnClickListener {
            openBmiCalculatorActivity()
        }
    }

    private fun openBmiCalculatorActivity() {
        val intent = Intent(this, BmiCalculatorActivity::class.java)
        startActivity(intent)
    }
}
package com.example.universalapp

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class BmiCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)

        val calculateBtn: Button = findViewById(R.id.btn_calculate)
        val height: EditText = findViewById(R.id.height)
        val weight: EditText = findViewById(R.id.weight)
        val result: TextView = findViewById(R.id.result)

        calculateBtn.setOnClickListener {
            if (weight.text.toString() == "") {
                Toast.makeText(applicationContext, "Enter your weight", Toast.LENGTH_SHORT)
                    .show()
            } else if (height.text.toString() == "") {
                Toast.makeText(applicationContext, "Enter your height", Toast.LENGTH_SHORT)
                    .show()
            } else if (height.text.toString() == "0") {
                Toast.makeText(applicationContext, "Height should not be 0!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val h = height.text.toString().toFloat() / 100 // /100 to get height in meter
                val w = weight.text.toString().toFloat()
                val bmi = w / (h * h) // formula to calculate the BMI\
                if (bmi <= 18.5) {
                    result.text = "%.1f".format(bmi).plus(" BMI").plus("\n Underweight")
                    result.setTextColor(Color.parseColor("#469eeb"))
                } else if (bmi > 18.5 && bmi <= 25.0) {
                    result.text = "%.1f".format(bmi).plus(" BMI").plus("\n Normal")
                    result.setTextColor(Color.parseColor("#02a121"))
                } else {
                    result.text = "%.1f".format(bmi).plus(" BMI").plus("\n Overweight")
                    result.setTextColor(Color.parseColor("#ff425f"))
                }

                hideSoftKeyboard(calculateBtn) // to close keyboard after tapping the button
            }
        }
    }

    private fun hideSoftKeyboard(view: View) {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
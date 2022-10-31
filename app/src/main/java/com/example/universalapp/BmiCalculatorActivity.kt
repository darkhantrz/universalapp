package com.example.universalapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BmiCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)

        val calculateBtn: Button = findViewById(R.id.btn_calculate)
        val height: EditText = findViewById(R.id.height)
        val weight: EditText = findViewById(R.id.weight)
        val result: TextView = findViewById(R.id.result)

        calculateBtn.setOnClickListener {
            if (height == null || weight == null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val h = height.text.toString().toFloat() / 100 // /100 to get height in meter
                val w = weight.text.toString().toFloat()
                val res = w / (h * h) // formula to calculate the BMI\
                if (res <= 18.5) {
                    result.text = "%.1f".format(res).plus(" BMI").plus("\n Underweight")
                    result.setTextColor(Color.parseColor("#469eeb"))
                } else if (res > 18.5 && res <= 25.0) {
                    result.text = "%.1f".format(res).plus(" BMI").plus("\n Normal")
                    result.setTextColor(Color.parseColor("#02a121"))
                } else {
                    result.text = "%.1f".format(res).plus(" BMI").plus("\n Overweight")
                    result.setTextColor(Color.parseColor("#ff425f"))
                }

                hideSoftKeyboard(calculateBtn)
            }
        }
    }

    private fun hideSoftKeyboard(view: View) {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
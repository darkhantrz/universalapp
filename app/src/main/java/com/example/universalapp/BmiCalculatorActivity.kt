package com.example.universalapp

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.example.universalapp.database.BMI
import com.example.universalapp.database.BMIDatabase

class BmiCalculatorActivity : AppCompatActivity() {

    private val viewModel : BmiViewModel by viewModels()

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)

        val db = BMIDatabase.getDatabase(this)

        val calculateBtn: Button = findViewById(R.id.btn_calculate)
        val userName: EditText = findViewById(R.id.name)
        val height: EditText = findViewById(R.id.height)
        val weight: EditText = findViewById(R.id.weight)
        val result: TextView = findViewById(R.id.result)

        calculateBtn.setOnClickListener {
            viewModel.calculate(height.text.toString(), weight.text.toString())
            hideSoftKeyboard(calculateBtn)
            val bmiData = BMI(null, userName.text.toString(), weight.text.toString(), height.text.toString(), viewModel.result.value.toString())
            Thread {
                db.getBmiDao().addBmiData(bmiData)
            }.start()
        }

        val goBackToMainActivity: ImageView = findViewById(R.id.goBackToMain)

        goBackToMainActivity.setOnClickListener {
            finish()
        }
        viewModel.result.observe(this) {
            result.text = it
        }
        viewModel.color.observe(this) {
            result.setTextColor(Color.parseColor(it))
        }
    }

    private fun hideSoftKeyboard(view: View) {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}
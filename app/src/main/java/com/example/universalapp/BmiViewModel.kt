package com.example.universalapp

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.universalapp.database.BMI
import com.example.universalapp.database.BMIDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BmiViewModel : ViewModel() {

    var result = MutableLiveData<String>()
    var color = MutableLiveData<String>()

    fun calculate(userName: String, height: String, weight: String, context: Context) {
        if (weight != "" && height != "" && height != "0") {
            val h = height.toFloat() / 100 // /100 to get height in meter
            val w = weight.toFloat()
            val bmi = w / (h * h) // formula to calculate the BMI\
            if (bmi <= 18.5) {
                result.value = "%.1f".format(bmi).plus(" BMI").plus("\n Underweight")
            } else if (bmi > 18.5 && bmi <= 25.0) {
                result.value = "%.1f".format(bmi).plus(" BMI").plus("\n Normal")
                color.value = "#02a121"
            } else {
                result.value = "%.1f".format(bmi).plus(" BMI").plus("\n Overweight")
                color.value = "#ff425f"
            }

            val db = BMIDatabase.getDatabase(context)
            val bmiData = BMI(null, userName, weight, height, result.value.toString())
            GlobalScope.launch {
                db.getBmiDao().addBmiData(bmiData)
            }

        } else if (userName == "") {
            Toast.makeText(context, "Name should not be empty!", Toast.LENGTH_SHORT)
                .show()
        } else if (height == "" || height == "0") {
            Toast.makeText(context, "Height should not be empty or 0!", Toast.LENGTH_SHORT)
                .show()
        } else if (weight == "" || weight == "0") {
            Toast.makeText(context, "Weight should not be empty or 0!", Toast.LENGTH_SHORT)
                .show()
        }
    }


}
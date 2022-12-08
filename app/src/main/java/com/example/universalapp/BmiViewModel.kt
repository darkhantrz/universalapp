package com.example.universalapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    var result = MutableLiveData<String>()
    var color = MutableLiveData<String>()
    fun calculate(height: String, weight: String) {
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
        }
    }


}
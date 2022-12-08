package com.example.universalapp.database

import androidx.lifecycle.LiveData

class BmiRepository(private val bmiDao: BMIDatabaseDao) {

    val readAllData: LiveData<List<BMI>> = bmiDao.readAllData()

    fun addBmiData(bmi: BMI) {
        bmiDao.addBmiData(bmi)
    }

}
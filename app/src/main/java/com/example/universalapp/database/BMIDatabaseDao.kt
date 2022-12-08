package com.example.universalapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BMIDatabaseDao {
    @Insert
    fun addBmiData(bmi: BMI)

    @Query("SELECT * FROM bmi_data ORDER BY id ASC")
    fun readAllData(): LiveData<List<BMI>>
}
package com.example.universalapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BMIDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBmiData(bmi: BMI)

    @Query("SELECT * FROM bmi_data ORDER BY id ASC")
    fun readAllData(): LiveData<List<BMI>>

    @Query("SELECT * FROM bmi_data ORDER BY id DESC LIMIT 1")
    fun selectLastEnteredNameData(): LiveData<List<BMI>>

//    @Query("SELECT weight FROM bmi_data ORDER BY id DESC LIMIT 1")
//    fun selectLastEnteredWeightData(): LiveData<List<BMI>>
//
//    @Query("SELECT height FROM bmi_data ORDER BY id DESC LIMIT 1")
//    fun selectLastEnteredHeightData(): LiveData<List<BMI>>
//
//    @Query("SELECT result FROM bmi_data ORDER BY id DESC LIMIT 1")
//    fun selectLastEnteredResultData(): LiveData<List<BMI>>
}
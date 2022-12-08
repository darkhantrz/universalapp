package com.example.universalapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bmi_data")
data class BMI(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "weight")
    val weight: String,
    @ColumnInfo(name = "height")
    val height: String,
    @ColumnInfo(name = "result")
    val result: String
)
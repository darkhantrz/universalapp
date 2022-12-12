package com.example.universalapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bmi_data")
data class BMI(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String? = null,
    @ColumnInfo(name = "weight")
    val weight: String? = null,
    @ColumnInfo(name = "height")
    val height: String? = null,
    @ColumnInfo(name = "result")
    val result: String? = null
)
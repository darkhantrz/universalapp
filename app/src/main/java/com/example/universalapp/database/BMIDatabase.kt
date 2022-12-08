package com.example.universalapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BMI::class], version = 1)
abstract class BMIDatabase : RoomDatabase() {

    abstract fun getBmiDao(): BMIDatabaseDao

    companion object {
        fun getDatabase(context: Context): BMIDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                BMIDatabase::class.java,
                "bmi_db.db"
            ).build()
        }
    }
}
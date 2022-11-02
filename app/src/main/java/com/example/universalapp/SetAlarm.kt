package com.example.universalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universalapp.databinding.ActivityMainBinding
import com.example.universalapp.databinding.ActivitySetAlarmBinding

class SetAlarm : AppCompatActivity() {
    lateinit var binding: ActivitySetAlarmBinding
    private val adapter = AlarmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()


        val goBackToMainActivity: ImageView = binding.goBackToMain

        goBackToMainActivity.setOnClickListener {
            finish()
        }
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@SetAlarm)
            rcView.adapter = adapter
        }
    }

}
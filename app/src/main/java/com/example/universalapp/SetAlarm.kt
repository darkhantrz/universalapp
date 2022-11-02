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
    private val alarmIdList = listOf(R.drawable.alarm1, R.drawable.alarm1, R.drawable.alarm1, R.drawable.alarm1)
    private var index = 0

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

            btnAddAlarm.setOnClickListener {
                if (index > 3) index = 0
                val alarm = Alarm(alarmIdList[index], "Alarm ${index+1}")
                adapter.addAlarm(alarm)
                index++
            }
        }
    }

}
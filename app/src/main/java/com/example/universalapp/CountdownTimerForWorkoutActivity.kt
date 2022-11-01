package com.example.universalapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.LocaleList
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.sql.Time
import java.util.*
import java.util.concurrent.TimeUnit

class CountdownTimerForWorkoutActivity : AppCompatActivity() {
    private var duration = 120
    private var timerRunning = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown_timer_for_workout)

        val hour: EditText = findViewById(R.id.hour)
        val min: EditText = findViewById(R.id.min)
        val seconds: EditText = findViewById(R.id.second)
        val start: FloatingActionButton = findViewById(R.id.play)

        val inputEditText : EditText = findViewById(R.id.hms)


        start.setOnClickListener {
            if (!timerRunning) {
                timerRunning = true
                hour.isFocusable = false
                min.isFocusable = false
                seconds.isFocusable = false

                if (inputEditText.text.toString() != "") {
                    val input = inputEditText.text.toString()
                    print(input)
                    val inputHourMinSec = input.split(":")
                    val inputHour = inputHourMinSec[0].toLong()
                    val inputMin = inputHourMinSec[1].toLong()
                    val inputSeconds = inputHourMinSec[2].toLong()
                    if (inputHour > 0) {
                        duration = (inputHour * 120).toInt()
                    }
                    if (inputMin > 0) {
                        duration += inputMin.toInt()
                    }
                    if (inputSeconds > 0) {
                        duration = (inputSeconds / 60).toInt()
                    }
                }

                object : CountDownTimer((duration * 30000).toLong(), 1000) {

                    // Callback function, fired on regular interval
                    override fun onTick(millisUntilFinished: Long) {
                        val time = String.format(
                            Locale.getDefault(),
                            "%02d:%02d:%02d",
                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                                    TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(
                                            millisUntilFinished
                                        )
                                    ),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                    TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(
                                            millisUntilFinished
                                        )
                                    )
                        )

                        val hoursMinSec = time.split(":")

                        hour.setText(hoursMinSec[0].toString())
                        min.setText(hoursMinSec[1].toString())
                        seconds.setText(hoursMinSec[2].toString())
                    }

                    // Callback function, fired
                    // when the time is up
                    override fun onFinish() {
                        duration = 120
                        timerRunning = false
                    }
                }.start()
            } else {
                Toast.makeText(applicationContext, "Timer is already running", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

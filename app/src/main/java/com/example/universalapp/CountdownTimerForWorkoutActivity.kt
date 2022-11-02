package com.example.universalapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.LocaleList
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.sql.Time
import java.util.*
import java.util.concurrent.TimeUnit

class CountdownTimerForWorkoutActivity : AppCompatActivity() {
    private var duration: Long = 0
    private var timerRunning = false
    lateinit var timer: CountDownTimer

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown_timer_for_workout)

        val hour: EditText = findViewById(R.id.hour)
        val min: EditText = findViewById(R.id.min)
        val seconds: EditText = findViewById(R.id.second)
        val start: FloatingActionButton = findViewById(R.id.play)
        val pause: FloatingActionButton = findViewById(R.id.pause)
        val stop: FloatingActionButton = findViewById(R.id.stop)

//        val inputEditText : EditText = findViewById(R.id.hms)

        val goBackToMainActivity: ImageView = findViewById(R.id.goBackToMain)

        goBackToMainActivity.setOnClickListener {
            finish()
        }


        start.setOnClickListener {
            if (!timerRunning) {
                timerRunning = true
                hour.isFocusable = false
                min.isFocusable = false
                seconds.isFocusable = false
                var sec = 0

                if (hour.text.toString().toInt() > 0) {
                    duration += hour.text.toString().toLong() * 3600
                }
                if (min.text.toString().toInt() > 0) {
                    duration += min.text.toString().toInt() * 60
                }
                if (seconds.text.toString().toInt() > 0) {
                    duration += seconds.text.toString().toInt()
                }

                timer = object : CountDownTimer(duration * 1000, 1000) {

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

                    override fun onFinish() {
                        duration = 120
                        timerRunning = false
                    }
                }.start()
            } else {
                Toast.makeText(applicationContext, "Timer is already running", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        pause.setOnClickListener {
//            if (!timerRunning) {
//                timer.cancel()
//            }
        }

        stop.setOnClickListener {
//            if (!timerRunning) {
//                timer.cancel()
//                hour.setText("00")
//                min.setText("00")
//                seconds.setText("00")
//                timerRunning = false
//                hour.isFocusable = true
//                min.isFocusable = true
//                seconds.isFocusable = true
//            }
        }
    }
}

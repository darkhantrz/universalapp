package com.example.universalapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import com.example.universalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.bmi -> { openBmiCalculatorActivity() }
                    R.id.countdown -> { openCountdownActivity() }
                    R.id.weather -> { openWeatherForecastActivity() }
                    R.id.alarm -> { openSetAlarmActivity() }
                }
                true
            }

        }

        val openNavDrawer : ImageView = binding.openNavDrawer
        openNavDrawer.setOnClickListener {
            binding.drawerLayout.open()
        }

        val bmiCalculatorCardView : CardView = binding.cardView1
        bmiCalculatorCardView.setOnClickListener {
            openBmiCalculatorActivity()
        }

        val countdownTimerCardView : CardView = binding.cardView2
        countdownTimerCardView.setOnClickListener {
            openCountdownActivity()
        }

        val weatherForecastCardView : CardView = binding.cardView3
        weatherForecastCardView.setOnClickListener {
            openWeatherForecastActivity()
        }

        val setAlarmCardView : CardView = binding.cardView4
        setAlarmCardView.setOnClickListener {
            openSetAlarmActivity()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openBmiCalculatorActivity() {
        val intent = Intent(this, BmiCalculatorActivity::class.java)
        startActivity(intent)
        binding.drawerLayout.close()
    }

    private fun openCountdownActivity() {
        val intent = Intent(this, CountdownTimerForWorkoutActivity::class.java)
        startActivity(intent)
        binding.drawerLayout.close()
    }

    private fun openWeatherForecastActivity() {
        val intent = Intent(this, WeatherForecastActivity::class.java)
        startActivity(intent)
        binding.drawerLayout.close()
    }

    private fun openSetAlarmActivity() {
        val intent = Intent(this, SetAlarm::class.java)
        startActivity(intent)
        binding.drawerLayout.close()
    }
}
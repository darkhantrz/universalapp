package com.example.universalapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.universalapp.databinding.ActivityMainBinding
import com.example.universalapp.databinding.ActivityWeatherForecastBinding
import kotlin.random.Random

class WeatherForecastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherForecastBinding
    private val link = arrayOf(
        "https://iso.500px.com/wp-content/uploads/2016/03/stock-photo-142984111.jpg",
        "https://images.ctfassets.net/hrltx12pl8hq/6czYVzKLCtCAjcfDc6Q9h2/b268534ee924bcd993e530919d5f96d1/Holiday-Look-Book_Thumb.jpg?fit=fill&w=480&h=270",
        "https://iso.500px.com/wp-content/uploads/2016/11/stock-photo-159533631-1500x1000.jpg",
        "https://ichef.bbci.co.uk/news/976/cpsprodpb/A20B/production/_123138414_1ae36bae-44c9-4277-89a0-7b41aaca2cdb.jpg",
        "https://img-19.commentcamarche.net/AINHgQU6hzAaA-eacqk4lYu9IhE=/1500x/smart/d8c10e7fd21a485c909a5b4c5d99e611/ccmcms-commentcamarche/20456790.jpg"
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherForecastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image1.load(link[Random.nextInt(link.size)]) {
            crossfade(true)
            crossfade(500)
            transformations(RoundedCornersTransformation(100f))
        }

        binding.btnNxtImg.setOnClickListener {

            binding.image1.load(link[Random.nextInt(link.size)]) {
                crossfade(true)
                crossfade(500)
                transformations(RoundedCornersTransformation(100f))
            }

        }


        val goBackToMainActivity: ImageView = findViewById(R.id.goBackToMain)

        goBackToMainActivity.setOnClickListener {
            finish()
        }
    }
}
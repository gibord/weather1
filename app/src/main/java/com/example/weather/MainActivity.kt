package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.view.weatherlist.WeatherListfragment

internal class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.button1.text="Изменения"
        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container, WeatherListfragment.newInstance()).commit()
        }
    }
}
package com.example.weather.model

import com.example.weather.domain.Weather
import com.example.weather.domain.getRussianCities
import com.example.weather.domain.getWorldCities

class RepositoryRemoteImpl : RepositoryOne {

    override fun getWeather(lat: Double, lon: Double): Weather {
        Thread {
            Thread.sleep(300L)
        }.start()
        return Weather()
    }
}
package com.example.weather.model

import com.example.weather.domain.Weather

class RepositoryLocallmp : Repository {
    override fun getListWeather(): List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}
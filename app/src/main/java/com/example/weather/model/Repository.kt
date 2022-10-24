package com.example.weather.model

import com.example.weather.domain.Weather


interface RepositoryOne {
    fun getWeather(lat : Double,lon : Double): Weather
}
interface RepositoryMany {
    fun getListWeather(location: Location): List<Weather>
}
sealed class Location{
    object Russian:Location()
    object World:Location()
}
package com.nagarro.bhagwat.weatherapp.model

data class WeatherApiResponse (
    var count: Long,
    val data: List<WeatherData>? = null
)
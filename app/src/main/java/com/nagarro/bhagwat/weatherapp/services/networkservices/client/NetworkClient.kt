package com.nagarro.bhagwat.weatherapp.services.networkservices.client

import android.content.Context
import com.nagarro.bhagwat.weatherapp.model.WeatherApiResponse

interface NetworkClient{
    suspend fun getDataByCity(context:Context,city:String):WeatherApiResponse?
    suspend fun getDataByPincode(context:Context,pincode:Long):WeatherApiResponse?
    suspend fun getDataByLatLon(context:Context,lat:Double,lon:Double):WeatherApiResponse?
}
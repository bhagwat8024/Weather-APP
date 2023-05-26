package com.nagarro.bhagwat.weatherapp.services.networkservices.client.service

import android.content.Context
import com.nagarro.bhagwat.weatherapp.exceptions.CityNotFoundException
import com.nagarro.bhagwat.weatherapp.exceptions.ConnectionNotFoundException
import com.nagarro.bhagwat.weatherapp.model.WeatherApiResponse
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.NetworkClient

class NetworkService(var client: NetworkClient,var mContext:Context){

    fun setNetworkClient(client: NetworkClient){
        this.client = client
    }

    @Throws(CityNotFoundException::class, ConnectionNotFoundException::class)
    suspend fun getWeatherDataByCity(city:String):WeatherApiResponse?{
            return  client.getDataByCity(context = mContext,city)
    }

    @Throws(CityNotFoundException::class,ConnectionNotFoundException::class)
    suspend fun getWeatherDataByPincode(pincode:Long):WeatherApiResponse?{
        return client.getDataByPincode(context = mContext,pincode)
    }
}
package com.nagarro.bhagwat.weatherapp.services.networkservices.client.service

import android.content.Context
import com.nagarro.bhagwat.weatherapp.exceptions.CityNotFoundException
import com.nagarro.bhagwat.weatherapp.exceptions.ConnectionNotFoundException
import com.nagarro.bhagwat.weatherapp.exceptions.NoInternetConnectionException
import com.nagarro.bhagwat.weatherapp.model.WeatherApiResponse
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.NetworkClient
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.service.NetworkUtils.checkInternetConnection

class NetworkService(var client: NetworkClient,var mContext:Context){

    fun setNetworkClient(client: NetworkClient){
        this.client = client
    }

    @Throws(CityNotFoundException::class, ConnectionNotFoundException::class,NoInternetConnectionException::class)
    suspend fun getWeatherDataByCity(city:String):WeatherApiResponse?{
        checkInternetConnection(mContext) ?: throw NoInternetConnectionException("No Internet Connection")
            return  client.getDataByCity(context = mContext,city)
    }

    @Throws(CityNotFoundException::class,ConnectionNotFoundException::class,NoInternetConnectionException::class)
    suspend fun getWeatherDataByPincode(pincode:Long):WeatherApiResponse?{
        checkInternetConnection(mContext) ?: throw NoInternetConnectionException("No Internet Connection")
        return client.getDataByPincode(context = mContext,pincode)
    }
    @Throws(CityNotFoundException::class,ConnectionNotFoundException::class,NoInternetConnectionException::class)
    suspend fun getWeatherDataByLatLon(lat:Double,lon:Double):WeatherApiResponse?{
        checkInternetConnection(mContext) ?: throw NoInternetConnectionException("No Internet Connection")
        return client.getDataByLatLon(context = mContext,lat,lon)
    }

}
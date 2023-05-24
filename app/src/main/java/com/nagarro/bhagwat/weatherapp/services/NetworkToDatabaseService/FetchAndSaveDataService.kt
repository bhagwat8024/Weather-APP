package com.nagarro.bhagwat.weatherapp.services.NetworkToDatabaseService

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.nagarro.bhagwat.weatherapp.services.databaseservices.database.DatabaseService
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.retrofit.RetrofitClient
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.service.NetworkService

class FetchAndSaveDataService{
    suspend fun fetchAndSaveIntoDatabaseByCity(city:String,context:Context){

        var networkService:NetworkService = NetworkService(RetrofitClient(),context)
        var databaseService = DatabaseService(context)
        var weatherApiResponse = networkService.getWeatherDataByCity(city)

        weatherApiResponse?.data?.forEach{weatherData ->
            databaseService.insertWeatherData(weatherData)
        }

    }
}
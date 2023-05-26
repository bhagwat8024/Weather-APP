package com.nagarro.bhagwat.weatherapp.services.databaseservices.database

import android.content.Context
import com.nagarro.bhagwat.weatherapp.model.WeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

class DatabaseService(var mContext:Context){
    var database: WeatherDatabase = WeatherDatabase.getInstance(mContext)
     fun getWeatherDataList(): Flow<List<WeatherData>> {
        return database.weatherDataDAO().getAllWeatherDataList().catch {
             emit(listOf())
         }
    }

     fun insertWeatherData(weatherData: WeatherData){
        database?.weatherDataDAO()?.insertWeatherData(weatherData)
    }
}
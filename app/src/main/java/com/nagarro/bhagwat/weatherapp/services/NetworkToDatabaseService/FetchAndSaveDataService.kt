package com.nagarro.bhagwat.weatherapp.services.NetworkToDatabaseService

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.nagarro.bhagwat.weatherapp.exceptions.CityNotFoundException
import com.nagarro.bhagwat.weatherapp.exceptions.ConnectionNotFoundException
import com.nagarro.bhagwat.weatherapp.exceptions.NoInternetConnectionException
import com.nagarro.bhagwat.weatherapp.model.LatLonPair
import com.nagarro.bhagwat.weatherapp.services.databaseservices.database.DatabaseService
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.retrofit.RetrofitClient
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.service.NetworkService

class FetchAndSaveDataService{

    @Throws(CityNotFoundException::class, ConnectionNotFoundException::class,NoInternetConnectionException::class)
    suspend fun fetchAndSaveIntoDatabaseByCity(city:String,context:Context){
        val networkService:NetworkService = NetworkService(RetrofitClient(),context)
        val databaseService = DatabaseService(context)
        val weatherApiResponse = networkService.getWeatherDataByCity(city)
        weatherApiResponse?.data?.forEach{weatherData ->
            databaseService.insertWeatherData(weatherData)
        }
    }

    @Throws(CityNotFoundException::class, ConnectionNotFoundException::class,NoInternetConnectionException::class)
    suspend fun fetchAndSaveIntoDatabaseByPincode(pincode:Long,context:Context){
        val networkService:NetworkService = NetworkService(RetrofitClient(),context)
        val databaseService = DatabaseService(context)
        val weatherApiResponse = networkService.getWeatherDataByPincode(pincode)
        weatherApiResponse?.data?.forEach{weatherData ->
            databaseService.insertWeatherData(weatherData)
        }
    }

    @Throws(CityNotFoundException::class, ConnectionNotFoundException::class,NoInternetConnectionException::class)
    suspend fun fetchAndSaveIntoDatabaseByLatLon(lat:Double,lon:Double,context:Context){
        val networkService:NetworkService = NetworkService(RetrofitClient(),context)
        val databaseService = DatabaseService(context)
        val weatherApiResponse = networkService.getWeatherDataByLatLon(lat,lon)
        weatherApiResponse?.data?.forEach{weatherData ->
            databaseService.insertWeatherData(weatherData)
        }
    }

    @Throws(CityNotFoundException::class, ConnectionNotFoundException::class,NoInternetConnectionException::class)
    suspend fun reloadDataByLatLon(context: Context){
        val databaseService = DatabaseService(context)
        val listOfLatLonPair = databaseService.getAllLatLons()
        listOfLatLonPair.forEach{pair ->
            fetchAndSaveIntoDatabaseByLatLon(pair.lat,pair.lon,context)
        }
    }

}


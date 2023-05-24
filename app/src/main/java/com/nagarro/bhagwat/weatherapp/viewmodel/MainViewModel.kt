package com.nagarro.bhagwat.weatherapp.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.nagarro.bhagwat.weatherapp.model.WeatherApiResponse
import com.nagarro.bhagwat.weatherapp.model.WeatherData
import com.nagarro.bhagwat.weatherapp.services.NetworkToDatabaseService.FetchAndSaveDataService
import com.nagarro.bhagwat.weatherapp.services.databaseservices.database.DatabaseService
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.retrofit.RetrofitClient
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.service.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application):AndroidViewModel(application) {

    var databaseService = DatabaseService(application.applicationContext)
    private var weatherDataFlow = databaseService.getWeatherDataList()
    private var listOfWeatherData: LiveData<List<WeatherData>> = weatherDataFlow.asLiveData()
    var weatherDataListLiveData: LiveData<List<WeatherData>> = listOfWeatherData

    fun fetchData(context:Context,city:String){
        var networkService: NetworkService = NetworkService(RetrofitClient(),context)
        viewModelScope.launch {

            var weatherResponse: WeatherApiResponse?
            withContext(Dispatchers.IO) {
                weatherResponse = networkService.getWeatherDataByCity(city)
            }

            val weatherData = weatherResponse?.data?.get(0)
            if(weatherData!=null){
                //
            }

        }
    }

    fun fetchAndSaveWeather(context:Context,city:String){
        var fetchAndSaveDataService = FetchAndSaveDataService();
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                fetchAndSaveDataService.fetchAndSaveIntoDatabaseByCity(city,context);
            }
        }
    }

}
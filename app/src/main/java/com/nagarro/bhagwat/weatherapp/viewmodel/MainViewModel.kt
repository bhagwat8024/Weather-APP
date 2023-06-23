package com.nagarro.bhagwat.weatherapp.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.nagarro.bhagwat.weatherapp.exceptions.CityNotFoundException
import com.nagarro.bhagwat.weatherapp.exceptions.ConnectionNotFoundException
import com.nagarro.bhagwat.weatherapp.exceptions.NoInternetConnectionException
import com.nagarro.bhagwat.weatherapp.model.UiState
import com.nagarro.bhagwat.weatherapp.model.WeatherApiResponse
import com.nagarro.bhagwat.weatherapp.model.WeatherData
import com.nagarro.bhagwat.weatherapp.services.NetworkToDatabaseService.FetchAndSaveDataService
import com.nagarro.bhagwat.weatherapp.services.databaseservices.database.DatabaseService
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.retrofit.RetrofitClient
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.service.NetworkService
import com.nagarro.bhagwat.weatherapp.view.ToolBar
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.delayFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(application: Application):AndroidViewModel(application) {

    var databaseService = DatabaseService(application.applicationContext)

    private var weatherDataFlow = databaseService.getWeatherDataList()
    private var listOfWeatherData: LiveData<List<WeatherData>> = weatherDataFlow.asLiveData();

    var weatherDataListLiveData: LiveData<List<WeatherData>> = listOfWeatherData
    var toastMessageEvent:MutableLiveData<String> = MutableLiveData<String>()

    private var _uiState = MutableLiveData<UiState>()
    var uiState:LiveData<UiState> = _uiState

    init {
        _uiState.value = UiState.Data
    }

    fun fetchAndSaveWeather(context:Context,city:String){
        var fetchAndSaveDataService = FetchAndSaveDataService();
        viewModelScope.launch {
            try{
                withContext(Dispatchers.IO) {
                    fetchAndSaveDataService.fetchAndSaveIntoDatabaseByCity(city,context);
                }
            }
            catch (exception:CityNotFoundException){
                toastMessageEvent.value = exception.message
            }
            catch (exception:ConnectionNotFoundException){
                toastMessageEvent.value = exception.message
            }
            catch (exception:NoInternetConnectionException){
                toastMessageEvent.value = exception.message
            }

        }
    }

    fun reloadData(context:Context){

        val fetchAndSaveDataService = FetchAndSaveDataService();
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try{
                withContext(Dispatchers.IO) {
                    fetchAndSaveDataService.reloadDataByLatLon(context)
                }
            }
            catch (exception:CityNotFoundException){
                toastMessageEvent.value = exception.message
            }
            catch (exception:ConnectionNotFoundException){
                toastMessageEvent.value = exception.message
            }
            catch (exception:NoInternetConnectionException){
                toastMessageEvent.value = exception.message
            }
            finally {
                _uiState.value = UiState.Data
            }
        }

    }

}
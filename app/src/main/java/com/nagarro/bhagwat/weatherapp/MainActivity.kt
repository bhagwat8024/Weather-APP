package com.nagarro.bhagwat.weatherapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.nagarro.bhagwat.weatherapp.model.WeatherData
import com.nagarro.bhagwat.weatherapp.ui.theme.WeatherappTheme
import com.nagarro.bhagwat.weatherapp.view.ToolBar
import com.nagarro.bhagwat.weatherapp.view.WeatherDataShowList
import com.nagarro.bhagwat.weatherapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var weatherListLiveData: LiveData<List<WeatherData>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        weatherListLiveData = viewModel.weatherDataListLiveData

        setContent {
            WeatherappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(viewModel::fetchAndSaveWeather,this,weatherListLiveData)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    getData: (Context, String) -> Unit,
    context: Context,
    weatherListLiveData: LiveData<List<WeatherData>>
) {
    var firstWeatherData:WeatherData? by remember {
        mutableStateOf(null)
    }
    var weatherDataList:List<WeatherData>? by remember {
        mutableStateOf(null)
    }

    weatherListLiveData.observe(LocalLifecycleOwner.current){weatherList->
        println(firstWeatherData)
        firstWeatherData = if(weatherList.size==0) null else weatherList[0]
        weatherDataList = weatherList
    }

    Column {
        ToolBar(firstWeatherData, getData = getData,context)
        weatherDataList?.let { WeatherDataShowList(listOfWeatherData = it) }
    }
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherappTheme {
    }
}
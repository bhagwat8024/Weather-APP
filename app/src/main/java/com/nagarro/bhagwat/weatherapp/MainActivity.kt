package com.nagarro.bhagwat.weatherapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nagarro.bhagwat.weatherapp.model.WeatherData
import com.nagarro.bhagwat.weatherapp.ui.theme.WeatherappTheme
import com.nagarro.bhagwat.weatherapp.view.ShowToast
import com.nagarro.bhagwat.weatherapp.view.ToolBar
import com.nagarro.bhagwat.weatherapp.view.WeatherDataShowList
import com.nagarro.bhagwat.weatherapp.viewmodel.MainViewModel
import kotlinx.coroutines.launch

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
                    HomeScreen(viewModel::fetchAndSaveWeather,this,weatherListLiveData,viewModel.toastMessageEvent)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    getData: (Context, String) -> Unit,
    context: Context,
    weatherListLiveData: LiveData<List<WeatherData>>,
    toastMessageLiveData:LiveData<String>
) {
    val weatherDataList:List<WeatherData>? by weatherListLiveData.observeAsState()
    var weatherDataListUse = weatherDataList?.reversed()
    var firstWeatherData:WeatherData? = weatherDataListUse?.get(0)

    LaunchedEffect(key1 = toastMessageLiveData ){
        val observer = Observer<String>{
            Toast.makeText(context,it,Toast.LENGTH_LONG).show()
        }
        toastMessageLiveData.observeForever(observer)
    }

    Column {
        ToolBar(firstWeatherData, getData = getData,context)
        weatherDataListUse?.let { WeatherDataShowList(listOfWeatherData = it) }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherappTheme {
    }
}
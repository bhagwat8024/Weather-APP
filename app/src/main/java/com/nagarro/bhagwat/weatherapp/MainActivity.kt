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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.nagarro.bhagwat.weatherapp.model.UiState
import com.nagarro.bhagwat.weatherapp.model.WeatherData
import com.nagarro.bhagwat.weatherapp.ui.theme.WeatherappTheme
import com.nagarro.bhagwat.weatherapp.view.Loading
import com.nagarro.bhagwat.weatherapp.view.SingleWeatherFullScreen
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
                val navController = rememberNavController()
                WeatherAPP(viewModel::fetchAndSaveWeather,viewModel::reloadData,this,weatherListLiveData,viewModel.toastMessageEvent,viewModel.uiState,navController)
            }
        }
    }
}

@Composable
fun WeatherAPP(
    getData: (Context, String) -> Unit,
    reloadData: (Context) -> Unit,
    context: Context,
    weatherListLiveData: LiveData<List<WeatherData>>,
    toastMessageLiveData: LiveData<String>,
    uiState: LiveData<UiState>,
    navController: NavHostController
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var weatherOnClick:(weatherData: WeatherData)->Unit = {
            val weatherJson = Gson().toJson(it)
            println(weatherJson)
            navController.navigate("singleWeatherFull?weatherData=$weatherJson")
        }
        NavHost(navController = navController, startDestination = "home" ){
             composable(route = "home"){
                 HomeScreen(getData,reloadData,context,weatherListLiveData,toastMessageLiveData,uiState,weatherOnClick)
             }
            composable(route="singleWeatherFull?weatherData={weatherData}",arguments = listOf(navArgument("weatherData"){type=
                NavType.StringType})){backStackEntry->
                SingleWeatherFullScreen(backStackEntry) { navController.navigateUp() }
            }
        }
    }
}



@Composable
fun HomeScreen(
    getData: (Context, String) -> Unit,
    reloadData: (Context) -> Unit,
    context: Context,
    weatherListLiveData: LiveData<List<WeatherData>>,
    toastMessageLiveData: LiveData<String>,
    uiState: LiveData<UiState>,
    weatherOnClick: (weatherData: WeatherData) -> Unit
) {
    val weatherDataList:List<WeatherData>? by weatherListLiveData.observeAsState()
    val weatherDataListUse = weatherDataList?.reversed()
    val firstWeatherData:WeatherData? = weatherDataListUse?.get(0)
    val uistate by uiState.observeAsState()

    LaunchedEffect(key1 = toastMessageLiveData ){
        val toastObserver = Observer<String>{
            Toast.makeText(context,it,Toast.LENGTH_LONG).show()
        }
        toastMessageLiveData.observeForever(toastObserver)
    }

    Column {
        ToolBar(firstWeatherData, getData = getData,context,reloadData)
        when(uistate){
            UiState.Loading-> Loading()
            UiState.Data->weatherDataListUse?.let { WeatherDataShowList(listOfWeatherData = it,weatherOnClick)}
            UiState.Error->{}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherappTheme {
    }
}



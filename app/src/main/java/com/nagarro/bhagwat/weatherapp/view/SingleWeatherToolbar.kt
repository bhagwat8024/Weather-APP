package com.nagarro.bhagwat.weatherapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.nagarro.bhagwat.weatherapp.model.WeatherData

@Composable
fun SingleWeatherToolbar(weatherData: WeatherData, onBackPressed: () -> Unit){
    SmallTopAppBar(
        title = {
            Box(contentAlignment = Alignment.Center) {
                Text(text = weatherData.city_name, fontSize = 16.sp, textAlign = TextAlign.Center)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary,
            Color.Transparent,
            Color.White,
            Color.White,
            Color.White),
        navigationIcon = {
            IconButton(onClick = {onBackPressed()}) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Refresh")
            }
        }
    )
}
package com.nagarro.bhagwat.weatherapp.view

import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import com.google.gson.Gson
import com.nagarro.bhagwat.weatherapp.model.WeatherData

@Composable
fun SingleWeatherFullScreen(navBackStackEntry: NavBackStackEntry,onBackPressed:()->Unit){
    val weatherDataJson = navBackStackEntry.arguments?.getString("weatherData")
    val weatherData = Gson().fromJson(weatherDataJson,WeatherData::class.java)
    Column {
        SingleWeatherToolbar(weatherData = weatherData,onBackPressed)
        SingleWeatherDataScreen(weatherData = weatherData)
    }
}

@Composable
fun SingleWeatherDataScreen(weatherData: WeatherData){
    Card(modifier = Modifier
        .background(
            color = MaterialTheme.colorScheme.primary,
        )
        .padding(top = 30.dp).fillMaxHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(
            topStart = 24.dp,
            topEnd = 24.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
    ){
        Column(modifier = Modifier.padding(20.dp,20.dp)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = weatherData.city_name, modifier = Modifier
                    .weight(1f)
                    .padding(12.dp), color = Color.Black)
                Text(text = weatherData.wind_cdir_full, textAlign = TextAlign.End, modifier = Modifier
                    .weight(1f)
                    .padding(12.dp), color = Color.Black)
            }
            Row {
                Text(text = weatherData.ob_time, color = Color.Black, textAlign = TextAlign.Center, modifier = Modifier.padding(12.dp))
            }
            Row {
                Text(text = weatherData.app_temp.toString() + "\u2103", fontSize = 80.sp, color = Color.Black, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = weatherData.weather.description, modifier = Modifier
                    .weight(1f)
                    .padding(12.dp), color = Color.Black)
                Text(text = weatherData.wind_cdir_full, textAlign = TextAlign.End, modifier = Modifier
                    .weight(1f)
                    .padding(12.dp), color = Color.Black)
            }
            HorizontalLine()
            Row(modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                ){
                    Column {
                        Text(text = "AQI", modifier = Modifier.padding(12.dp))
                        Text(text = String.format("%.1f", weatherData.aqi),color = Color.Black, textAlign = TextAlign.Center,fontSize = 30.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(12.dp))
                    }
                }
                VerticalLine()
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                ){
                    Column {
                        Text(text = "Wind", modifier = Modifier.padding(12.dp))
                        Text(text = " ${String.format("%.1f", weatherData.wind_speed)} m/s",color = Color.Black, textAlign = TextAlign.Center,fontSize = 30.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(12.dp))
                    }
                }
            }
            HorizontalLine()
            Row(modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                ){
                    Column {
                        Text(text = "UV", modifier = Modifier.padding(12.dp))
                        Text(text = String.format("%.1f", weatherData.uv),color = Color.Black, textAlign = TextAlign.Center,fontSize = 30.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(12.dp))
                    }
                }
                VerticalLine()
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                ){
                    Column {
                        Text(text = "Pressure", modifier = Modifier.padding(12.dp))
                        Text(text = "${ String.format("%.1f", weatherData.pres) } mb",color = Color.Black, textAlign = TextAlign.Center,fontSize = 30.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(12.dp))
                    }
                }
            }
            HorizontalLine()
            Row(modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                ){
                    Column {
                        Text(text = "sunrise", modifier = Modifier.padding(12.dp))
                        Text(text = weatherData.sunrise,color = Color.Black, textAlign = TextAlign.Center,fontSize = 30.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(12.dp))
                    }
                }
                VerticalLine()
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                ){
                    Column {
                        Text(text = "sunset", modifier = Modifier.padding(12.dp))
                        Text(text = weatherData.sunset,color = Color.Black, textAlign = TextAlign.Center,fontSize = 30.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun HorizontalLine(){
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = Stroke.HairlineWidth
        )
    }
}

@Composable
fun VerticalLine(){

}
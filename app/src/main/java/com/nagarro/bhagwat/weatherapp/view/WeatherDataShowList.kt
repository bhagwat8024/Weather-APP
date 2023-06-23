package com.nagarro.bhagwat.weatherapp.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nagarro.bhagwat.weatherapp.R
import com.nagarro.bhagwat.weatherapp.model.WeatherData


@Composable
fun WeatherDataShowList(listOfWeatherData:List<WeatherData>,weatherDataOnClick:(weatherData:WeatherData)->Unit){
    LazyColumn(){
        itemsIndexed(listOfWeatherData){index,weatherData->
            if(index==0){
                WeatherDataHeaderCard(weatherData = weatherData,weatherDataOnClick)
            }
            else{
                WeatherDataOtherCard(weatherData = weatherData,weatherDataOnClick)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WeatherDataHeaderCard(weatherData: WeatherData,weatherDataOnClick:(weatherData:WeatherData)->Unit){
    Card(modifier = Modifier
        .background(
            color = MaterialTheme.colorScheme.primary,
        )
        .padding(top = 24.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(
        topStart = 24.dp,
        topEnd = 24.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    ), onClick = {weatherDataOnClick(weatherData)}){
        Column(modifier = Modifier.padding(16.dp,16.dp)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = weatherData.city_name, modifier = Modifier
                    .weight(1f)
                    .padding(8.dp), color = Color.Black)
            }
            Row {
                Text(text = weatherData.ob_time, color = Color.Black, textAlign =TextAlign.Center, modifier = Modifier.padding(8.dp))
            }
            Row {
                Text(text = weatherData.app_temp.toString() + "\u2103", fontSize = 60.sp, color = Color.Black, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                iconMap[weatherData.weather.icon]?.let { painterResource(id = it) }
                    ?.let { Image(painter = it, contentDescription = null ,modifier = Modifier.width(40.dp).height(40.dp).padding(8.dp)) }
                Text(text = weatherData.weather.description, modifier = Modifier
                    .weight(1f)
                    .padding(8.dp), color = Color.Black)
                Text(text = weatherData.wind_cdir_full, textAlign = TextAlign.End, modifier = Modifier
                    .weight(1f)
                    .padding(8.dp), color = Color.Black)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WeatherDataOtherCard(weatherData: WeatherData,weatherDataOnClick:(weatherData:WeatherData)->Unit){
    Card(elevation = 4.dp, onClick = {weatherDataOnClick(weatherData)}){
        Column(modifier = Modifier.padding(16.dp,16.dp)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = weatherData.city_name, modifier = Modifier
                    .weight(1f)
                    .padding(8.dp), color = Color.Black)
                Text(text = weatherData.wind_cdir_full, textAlign = TextAlign.End, modifier = Modifier
                    .weight(1f)
                    .padding(8.dp), color = Color.Black)
            }
            Row {
                Text(text = weatherData.ob_time, color = Color.Black, textAlign =TextAlign.Center, modifier = Modifier.padding(8.dp))
            }
            Row {
                Text(text = weatherData.app_temp.toString() + "\u2103", fontSize = 60.sp, color = Color.Black, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                iconMap[weatherData.weather.icon]?.let { painterResource(id = it) }
                    ?.let { Image(painter = it, contentDescription = null ,modifier = Modifier.width(40.dp).height(40.dp).padding(8.dp)) }
                Text(text = weatherData.weather.description, modifier = Modifier
                    .weight(1f)
                    .padding(8.dp), color = Color.Black)
                Text(text = weatherData.wind_cdir_full, textAlign = TextAlign.End, modifier = Modifier
                    .weight(1f)
                    .padding(8.dp), color = Color.Black)
            }
        }
    }
}

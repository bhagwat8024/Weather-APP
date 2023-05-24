package com.nagarro.bhagwat.weatherapp.view

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ByCitySearch(getData:(Context, String)->Unit,context: Context){
    var cityName by remember {
        mutableStateOf("i")
    }
    getData(context,"sirohi")
    Column {
        TextField(value = cityName, onValueChange = {cityName = it}, colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ), placeholder = { Text(text = "Enter city name")})
        Button(onClick = { getData(context,cityName) }, modifier = Modifier.padding(vertical = 12.dp)) {
            Text(text = "Add")
        }
    }
}
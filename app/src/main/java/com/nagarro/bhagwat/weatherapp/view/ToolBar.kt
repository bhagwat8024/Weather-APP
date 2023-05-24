package com.nagarro.bhagwat.weatherapp.view

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nagarro.bhagwat.weatherapp.model.WeatherData

@Composable
fun ToolBar(weatherData:WeatherData?,getData:(Context, String)->Unit,context:Context){
    var addButtonExpanded by remember {
        mutableStateOf(false)
    }
    var title = if(weatherData==null)"Location" else weatherData.city_name
    SmallTopAppBar(
        title = {
            Box(contentAlignment = Alignment.Center) {
                Text(text = title, fontSize = 16.sp)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary,
            Color.Transparent,
            Color.White,
            Color.White,
            Color.White),
        navigationIcon = {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
        },
        actions = {
            IconButton(onClick = { addButtonExpanded = !addButtonExpanded }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
                AddButtonMenu(addButtonExpanded, { isExpanded -> addButtonExpanded = isExpanded }, getData = getData,context)
            }
        }
    )
}

@Composable
fun AddButtonMenu(expanded:Boolean,changeExpanded:(isExpanded:Boolean)->Unit,getData:(Context,String)->Unit,context:Context){
   DropdownMenu(expanded = expanded, onDismissRequest = { changeExpanded(false) }) {
       DropdownMenuItem(onClick = { /*TODO*/ }) {
          ByCitySearch(getData = getData,context)
       }
   }
}
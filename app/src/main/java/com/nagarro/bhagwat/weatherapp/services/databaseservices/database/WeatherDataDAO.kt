package com.nagarro.bhagwat.weatherapp.services.databaseservices.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nagarro.bhagwat.weatherapp.model.WeatherData
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDataDAO {

    @Insert
     fun insertWeatherData(weatherData: WeatherData)

    @Query("select * from WeatherData")
     fun getAllWeatherDataList(): Flow<List<WeatherData>>

    @Query("delete from WeatherData")
     fun deleteAll()

}
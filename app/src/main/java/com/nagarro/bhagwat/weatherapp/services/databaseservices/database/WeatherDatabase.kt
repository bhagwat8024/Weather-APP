package com.nagarro.bhagwat.weatherapp.services.databaseservices.database

import android.content.Context
import androidx.room.*
import com.nagarro.bhagwat.weatherapp.model.WeatherData

@Database(entities = [WeatherData::class], exportSchema = false, version = 1)
@TypeConverters(ListTypeConverter::class)
abstract class WeatherDatabase:RoomDatabase() {

    companion object{

        private const val DBNAME = "Weather_db"
        private var instance: WeatherDatabase? = null

        @Synchronized
        fun getInstance(context: Context): WeatherDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java, DBNAME
                ).build()
            }
            return instance!!
        }

    }

    abstract fun weatherDataDAO(): WeatherDataDAO
}
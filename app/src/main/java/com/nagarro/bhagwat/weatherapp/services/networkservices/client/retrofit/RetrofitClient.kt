package com.nagarro.bhagwat.weatherapp.services.networkservices.client.retrofit

import android.content.Context
import com.nagarro.bhagwat.weatherapp.BuildConfig.API_KEY
import com.nagarro.bhagwat.weatherapp.model.WeatherApiResponse
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.NetworkClient
import retrofit2.awaitResponse

class RetrofitClient: NetworkClient {
    private val client: WeatherRetrofitApi = RetrofitHelper.getInstance().create(WeatherRetrofitApi::class.java)
    override suspend fun getDataByCity(context: Context, city: String): WeatherApiResponse? {
        var weatherApiResponse = client.getByCityName(city,API_KEY).body()
        return weatherApiResponse
    }

    override suspend fun getDataByPincode(context: Context, pincode: Long): WeatherApiResponse? {
        var weatherApiResponse = client.getByPinCode(pincode,API_KEY).body()
        return weatherApiResponse
    }
}
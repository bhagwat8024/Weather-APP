package com.nagarro.bhagwat.weatherapp.services.networkservices.client.retrofit

import android.content.Context
import com.nagarro.bhagwat.weatherapp.BuildConfig.API_KEY
import com.nagarro.bhagwat.weatherapp.exceptions.CityNotFoundException
import com.nagarro.bhagwat.weatherapp.exceptions.ConnectionNotFoundException
import com.nagarro.bhagwat.weatherapp.model.WeatherApiResponse
import com.nagarro.bhagwat.weatherapp.services.networkservices.client.NetworkClient
import retrofit2.awaitResponse

class RetrofitClient: NetworkClient {
    private val NO_CONTENT_CODE = 204

    private val client: WeatherRetrofitApi = RetrofitHelper.getInstance().create(WeatherRetrofitApi::class.java)

    @Throws(CityNotFoundException::class,ConnectionNotFoundException::class)
    override suspend fun getDataByCity(context: Context, city: String): WeatherApiResponse? {
        var apiResponse = client.getByCityName(city,API_KEY)

        if(apiResponse.isSuccessful){
            if(apiResponse.code()==NO_CONTENT_CODE) {
                throw CityNotFoundException("City Not Found")
            }
            return apiResponse.body()
        }
        else{
            throw ConnectionNotFoundException("Connection Not Found")
        }
    }
    @Throws(CityNotFoundException::class,ConnectionNotFoundException::class)
    override suspend fun getDataByPincode(context: Context, pincode: Long): WeatherApiResponse? {
        var apiResponse = client.getByPinCode(pincode,API_KEY)

        if(apiResponse.isSuccessful){
            if(apiResponse.code()==NO_CONTENT_CODE) {
                throw CityNotFoundException("City Not Found")
            }
            return apiResponse.body()
        }
        else{
            throw ConnectionNotFoundException("Connection Not Found")
        }
    }
    @Throws(CityNotFoundException::class,ConnectionNotFoundException::class)
    override suspend fun getDataByLatLon(context: Context, lat:Double , lon:Double): WeatherApiResponse? {
        var apiResponse = client.getByLatLon(lat,lon, API_KEY)

        if(apiResponse.isSuccessful){
            if(apiResponse.code()==NO_CONTENT_CODE) {
                throw CityNotFoundException("City Not Found")
            }
            return apiResponse.body()
        }
        else{
            throw ConnectionNotFoundException("Connection Not Found")
        }
    }
}
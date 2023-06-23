package com.nagarro.bhagwat.weatherapp.services.networkservices.client.retrofit

import com.nagarro.bhagwat.weatherapp.model.WeatherApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRetrofitApi {
    @GET("current")
    suspend fun getByPinCode(@Query("postal_code") pincode:Long,@Query("key") apiKey:String):Response<WeatherApiResponse>

    @GET("current")
    suspend fun getByCityName(@Query("city") city:String,@Query("key") apiKey:String):Response<WeatherApiResponse>

    @GET("current")
    suspend fun getByLatLon(@Query("lat") lat:Double,@Query("lon") lon:Double,@Query("key") apiKey:String):Response<WeatherApiResponse>
}
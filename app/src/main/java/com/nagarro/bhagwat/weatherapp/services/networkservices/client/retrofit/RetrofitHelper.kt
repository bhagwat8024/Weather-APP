package com.nagarro.bhagwat.weatherapp.services.networkservices.client.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = "https://api.weatherbit.io/v2.0/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(
            RxJava3CallAdapterFactory.create()).build()
    }
}
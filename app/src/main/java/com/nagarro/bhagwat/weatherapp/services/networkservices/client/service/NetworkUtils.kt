package com.nagarro.bhagwat.weatherapp.services.networkservices.client.service

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtils {
    fun checkInternetConnection(context: Context): NetworkInfo? {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getActiveNetworkInfo()
    }
}
package com.nagarro.bhagwat.weatherapp.model

sealed class UiState {
    object Loading : UiState()
    object Data : UiState()
    object Error : UiState()
}
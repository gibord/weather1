package com.example.weather.view.weatherlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.viewmodel.AppState
import java.lang.Thread.sleep

class WeatherListViewModel(val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
    ViewModel() {
    fun sentRequest() {
       liveData.value = AppState.Loading      // Пошла загрузка
       Thread{
           sleep(2000L)
          // liveData.value = AppState.Success(Any())            // Пришел ответ
           liveData.postValue(AppState.Success(Any()))
       }.start()                                       // Запрос в репозиторий

    }
}
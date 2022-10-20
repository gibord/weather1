package com.example.weather.view.weatherlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.model.Repository
import com.example.weather.model.RepositoryLocallmp
import com.example.weather.model.RepositoryRemotelmp
import com.example.weather.viewmodel.AppState
import java.lang.Thread.sleep

class WeatherListViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
    ViewModel() {
   lateinit var repository: Repository
    fun getLiveData(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        //if (isConnection()) {
        // repository = RepositoryRemotelmp()
        repository = if (isConnection()) {
            RepositoryRemotelmp()
        } else {
            //repository = RepositoryLocallmp()
            RepositoryLocallmp()
        }
    }

    fun sentRequest() {
        // if (isConnection())
        liveData.value = AppState.Loading      // Пошла загрузка
        //liveData.postValue(AppState.Success(repository.getWeather(55.755826, 37.617299900000035)))
        if ((0..3).random()==1) {
            liveData.postValue(AppState.Error(throw IllegalAccessException("печалька")))
        } else {
            liveData.postValue(AppState.Success(repository.getWeather(55.755826, 37.617299900000035)))
        }
        /*Thread {
                sleep(2000L)
                // liveData.value = AppState.Success(Any())            // Пришел ответ
                liveData.postValue(AppState.Success(Any()))
            }.start()    */                                   // Запрос в репозиторий

    }

    private fun isConnection(): Boolean {
        return false
    }
}
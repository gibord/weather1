package com.example.weather.view.weatherlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.model.*
import com.example.weather.viewmodel.AppState
import java.lang.Thread.sleep

class WeatherListViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()
) :
    ViewModel() {
    lateinit var repositoryMulti: RepositoryMany
    lateinit var repositoryOne: RepositoryOne
    fun getLiveData(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        //if (isConnection()) {
        // repository = RepositoryRemotelmp()
        repositoryOne = if (isConnection()) {
            RepositoryRemoteImpl()
        } else {
            //repository = RepositoryLocallmp()
            RepositoryLocalImpl()
        }
        repositoryMulti = RepositoryLocalImpl()
    }

    fun getWheaherListForRussia() {
        sentRequest(Location.Russian)
    }
    fun getWheaherListForWorld() {
        sentRequest(Location.World)
    }

    private fun sentRequest(location: Location) {
        // if (isConnection())
        liveData.value = AppState.Loading      // Пошла загрузка
        //liveData.postValue(AppState.Success(repository.getWeather(55.755826, 37.617299900000035)))
        if (false) {
            liveData.postValue(AppState.Error(throw IllegalAccessException("печалька")))
        } else {
            liveData.postValue(AppState.SuccessMulti(repositoryMulti.getListWeather(location)))
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
package ru.m.kotlin_1.viewmodel

import androidx.lifecycle.*
import ru.m.kotlin_1.model.Repository
import ru.m.kotlin_1.model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData())
    : ViewModel(), LifecycleObserver {
    private val repository: Repository = RepositoryImpl()
    private val lifeCycleLiveData = MutableLiveData<String>()

    fun getLiveData() = liveDataToObserve

    fun getMovie() = getDataFromLocalSource()

    fun getData(): LiveData<AppState> {
        getDataFromLocalSource()
        return liveDataToObserve
    }

    fun getLifeCycleData() = lifeCycleLiveData

    fun getMovieFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repository.getMovieFromLocalStorage()))
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onViewStart() {
        lifeCycleLiveData.value = "Search"
    }
}
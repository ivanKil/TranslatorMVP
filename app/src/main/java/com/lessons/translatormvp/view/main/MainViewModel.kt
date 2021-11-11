package com.lessons.translatormvp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.view.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val interactor: MainInteractor) :
    BaseViewModel<AppState>() {
    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData
    private val _ldDataModel: MutableLiveData<AppState> = MutableLiveData()

    val ldDataModelInDb: LiveData<AppState>
        get() = _ldDataModel

    fun getDataFromHistory(word: String) {
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        job = viewModelCoroutineScope.launch {
            withContext(Dispatchers.IO) {
                _ldDataModel.postValue(interactor.getData(word, false))
            }
        }
    }

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        job = viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(interactor.getData(word, isOnline))
        }

    // Обрабатываем ошибки
    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}
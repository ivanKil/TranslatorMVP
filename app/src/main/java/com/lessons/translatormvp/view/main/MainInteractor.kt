package com.lessons.translatormvp.view.main

import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.presenter.Interactor
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}

package com.lessons.translatormvp.view.main

import com.lessons.translatormvp.di.NAME_LOCAL
import com.lessons.translatormvp.di.NAME_REMOTE
import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.presenter.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val remoteRepository: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}

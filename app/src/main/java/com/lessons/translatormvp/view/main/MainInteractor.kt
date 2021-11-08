package com.lessons.translatormvp.view.main

import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.presenter.Interactor

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                remoteRepository
            } else {
                localRepository
            }.getData(word)
        )

    }
}

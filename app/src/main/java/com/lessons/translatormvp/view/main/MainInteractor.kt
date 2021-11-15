package com.lessons.translatormvp.view.main

import com.lessons.models.DataModel
import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.model.repository.RepositoryLocal
import com.lessons.translatormvp.presenter.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}


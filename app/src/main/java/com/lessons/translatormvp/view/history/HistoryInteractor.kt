package com.lessons.translatormvp.view.history

import com.lessons.models.DataModel
import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.model.repository.Repository
import com.lessons.translatormvp.model.repository.RepositoryLocal
import com.lessons.translatormvp.presenter.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}

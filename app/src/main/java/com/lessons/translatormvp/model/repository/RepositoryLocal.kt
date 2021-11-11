package com.lessons.translatormvp.model.repository

import com.lessons.translatormvp.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}

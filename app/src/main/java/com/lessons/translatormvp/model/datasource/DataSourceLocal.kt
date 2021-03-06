package com.lessons.translatormvp.model.datasource

import com.lessons.translatormvp.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}

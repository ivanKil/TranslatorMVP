package com.lessons.translatormvp.model.datasource

import com.lessons.models.DataModel
import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.room.HistoryDao

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return if (word.isEmpty())
            historyDao.all().map { it.toDataModel() }
        else
            historyDao.getDataByWord(word).map { it.toDataModel() }
    }

    override suspend fun saveToDB(appState: AppState) {
        appState.toHistoryEntity()?.let { historyDao.insert(it) }
    }
}

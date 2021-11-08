package com.lessons.translatormvp.model.datasource

import com.lessons.translatormvp.model.data.DataModel

class DataSourceLocal(
    private val remoteProvider: DataSource<List<DataModel>> = RoomDataBaseImplementation()
) :
    DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> =
        remoteProvider.getData(word)
}

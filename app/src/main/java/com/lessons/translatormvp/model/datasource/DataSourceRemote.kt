package com.lessons.translatormvp.model.datasource

import com.lessons.translatormvp.model.data.DataModel

class DataSourceRemote(private val remoteProvider: DataSource<List<DataModel>> = RetrofitImplementation()) :
    DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> =
        remoteProvider.getData(word)
}

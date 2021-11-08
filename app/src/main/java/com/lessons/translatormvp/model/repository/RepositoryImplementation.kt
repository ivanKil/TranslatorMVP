package com.lessons.translatormvp.model.repository

import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}

package com.lessons.translatormvp.model.repository

import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.datasource.DataSource
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}

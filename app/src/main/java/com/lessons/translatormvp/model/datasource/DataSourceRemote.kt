package com.lessons.translatormvp.model.datasource

import com.lessons.translatormvp.model.data.DataModel
import io.reactivex.Observable

class DataSourceRemote(private val remoteProvider: DataSource<List<DataModel>> = RetrofitImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}

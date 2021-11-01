package com.lessons.translatormvp.model.datasource

import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.datasource.DataSource
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

package com.lessons.translatormvp.model.datasource

interface DataSource<T> {
    suspend fun getData(word: String): T
}

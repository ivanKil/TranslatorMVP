package com.lessons.translatormvp.model.repository

interface Repository<T> {
    suspend fun getData(word: String): T
}

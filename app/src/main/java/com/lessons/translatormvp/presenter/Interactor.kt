package com.lessons.translatormvp.presenter

interface Interactor<T> {
    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}
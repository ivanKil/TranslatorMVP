package com.lessons.translatormvp.presenter

import com.lessons.translatormvp.model.data.AppState
import com.lessons.translatormvp.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}

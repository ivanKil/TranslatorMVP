package com.lessons.translatormvp.view.base

import com.lessons.translatormvp.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}

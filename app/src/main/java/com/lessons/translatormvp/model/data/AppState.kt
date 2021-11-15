package com.lessons.translatormvp.model.data

import com.lessons.models.DataModel
import com.lessons.translatormvp.room.HistoryEntity
import com.lessons.translatormvp.utils.ui.convertMeaningsToString

sealed class AppState {
    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()

    fun toHistoryEntity(): HistoryEntity? {
        return when (this) {
            is Success -> {
                val searchResult = data
                if (searchResult.isNullOrEmpty() || searchResult[0].text.isNullOrEmpty()) {
                    null
                } else {
                    HistoryEntity(
                        searchResult[0].text!!,
                        convertMeaningsToString(searchResult[0].meanings ?: listOf())
                    )
                }
            }
            else -> null
        }
    }
}

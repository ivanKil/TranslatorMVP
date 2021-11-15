package com.lessons.models

import com.google.gson.annotations.SerializedName


class DataModel(
    @SerializedName(TEXT) val text: String?,
    @SerializedName(MEANINGS) val meanings: List<Meanings>?
) {
    companion object {
        private const val TEXT = "text"
        private const val MEANINGS = "meanings"
    }
}

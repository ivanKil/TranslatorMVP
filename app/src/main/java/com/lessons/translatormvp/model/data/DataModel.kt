package com.lessons.translatormvp.model.data

import com.google.gson.annotations.SerializedName

private const val TEXT = "text"
private const val MEANINGS = "meanings"

class DataModel(
    @SerializedName(TEXT) val text: String?,
    @SerializedName(MEANINGS) val meanings: List<Meanings>?
)

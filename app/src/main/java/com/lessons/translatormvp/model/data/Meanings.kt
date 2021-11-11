package com.lessons.translatormvp.model.data

import com.google.gson.annotations.SerializedName

private const val TRANSLATION = "translation"
private const val IMAGE_URL = "imageUrl"

class Meanings(
    @SerializedName(TRANSLATION) val translation: Translation?,
    @SerializedName(IMAGE_URL) val imageUrl: String?
)
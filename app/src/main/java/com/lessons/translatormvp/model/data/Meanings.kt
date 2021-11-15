package com.lessons.translatormvp.model.data

import com.google.gson.annotations.SerializedName

class Meanings(
    @SerializedName(TRANSLATION) val translation: Translation?,
    @SerializedName(IMAGE_URL) val imageUrl: String?
) {
    companion object {
        private const val TRANSLATION = "translation"
        private const val IMAGE_URL = "imageUrl"
    }
}
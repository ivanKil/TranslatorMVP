package com.lessons.translatormvp.model.data

import com.google.gson.annotations.SerializedName

class Translation(@SerializedName(TEXT) val translation: String?) {
    companion object {
        private const val TEXT = "text"
    }
}

package com.lessons.models

import com.google.gson.annotations.SerializedName

class Translation(@SerializedName(TEXT) val translation: String?) {
    companion object {
        private const val TEXT = "text"
    }
}

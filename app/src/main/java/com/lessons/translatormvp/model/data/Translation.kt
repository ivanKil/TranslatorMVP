package com.lessons.translatormvp.model.data

import com.google.gson.annotations.SerializedName

private const val TEXT = "text"

class Translation(@field:SerializedName("text") val translation: String?)

package com.lessons.translatormvp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.lessons.translatormvp.model.data.DataModel
import com.lessons.translatormvp.model.data.Meanings
import com.lessons.translatormvp.model.data.Translation

private const val WORD = "word"
private const val DESCRIPTION = "description"

@Entity(indices = arrayOf(Index(value = arrayOf(WORD), unique = true)))
class HistoryEntity(
    @PrimaryKey
    @ColumnInfo(name = WORD) var word: String,
    @ColumnInfo(name = DESCRIPTION) var description: String?
) {
    fun toDataModel() =
        DataModel(word, description?.split(",")?.map { it -> Meanings(Translation(it), "") })
}

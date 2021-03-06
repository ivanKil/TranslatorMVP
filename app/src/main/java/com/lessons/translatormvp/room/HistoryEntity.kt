package com.lessons.translatormvp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.lessons.models.DataModel
import com.lessons.models.Meanings
import com.lessons.models.Translation


@Entity(indices = arrayOf(Index(value = arrayOf(HistoryEntity.WORD), unique = true)))
class HistoryEntity(
    @PrimaryKey
    @ColumnInfo(name = WORD) var word: String,
    @ColumnInfo(name = DESCRIPTION) var description: String?
) {
    fun toDataModel() =
        DataModel(word, description?.split(",")?.map { it -> Meanings(Translation(it), "") })

    companion object {
        const val WORD = "word"
        private const val DESCRIPTION = "description"
    }
}

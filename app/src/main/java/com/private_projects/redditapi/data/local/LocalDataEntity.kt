package com.private_projects.redditapi.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "local_data")
data class LocalDataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NotNull
    val id: Long = 0L,
    val title: String,
    val popularity: Int,
    val comments: Int
)
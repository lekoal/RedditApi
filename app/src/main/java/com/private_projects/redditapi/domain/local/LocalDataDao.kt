package com.private_projects.redditapi.domain.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.private_projects.redditapi.data.local.LocalDataEntity

@Dao
abstract class LocalDataDao {
    @Query("SELECT * FROM local_data LIMIT :size")
    abstract suspend fun getData(size: Int): List<LocalDataEntity>

    @Insert
    abstract suspend fun insert(data: LocalDataEntity)

    @Insert
    abstract suspend fun insertAll(dataList: List<LocalDataEntity>)
}
package com.private_projects.redditapi.domain.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.private_projects.redditapi.data.local.LocalDataEntity

@Dao
interface LocalDataDao {
    @Query("SELECT * FROM local_data")
    suspend fun getData(): List<LocalDataEntity>

    @Insert
    suspend fun insert(data: LocalDataEntity)

    @Insert
    suspend fun insertAll(dataList: List<LocalDataEntity>)
}
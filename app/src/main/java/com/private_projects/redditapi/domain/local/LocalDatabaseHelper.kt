package com.private_projects.redditapi.domain.local

import com.private_projects.redditapi.data.local.LocalDataEntity

interface LocalDatabaseHelper {
    suspend fun getAll(size: Int): List<LocalDataEntity>
    suspend fun insert(data: LocalDataEntity)
    suspend fun insertAll(dataList: List<LocalDataEntity>)
}
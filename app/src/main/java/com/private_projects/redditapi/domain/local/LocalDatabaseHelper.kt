package com.private_projects.redditapi.domain.local

import com.private_projects.redditapi.data.local.LocalDataEntity

interface LocalDatabaseHelper {
    suspend fun getAll(): List<LocalDataEntity>
    suspend fun insert(data: LocalDataEntity)
    suspend fun insertAll(dataList: List<LocalDataEntity>)
}
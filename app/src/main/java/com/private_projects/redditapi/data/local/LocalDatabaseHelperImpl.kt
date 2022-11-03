package com.private_projects.redditapi.data.local

import com.private_projects.redditapi.domain.local.LocalDatabase
import com.private_projects.redditapi.domain.local.LocalDatabaseHelper

class LocalDatabaseHelperImpl(private val localDatabase: LocalDatabase) : LocalDatabaseHelper {
    override suspend fun getAll(): List<LocalDataEntity> {
        return localDatabase.localDataDao().getData()
    }

    override suspend fun insert(data: LocalDataEntity) {
        localDatabase.localDataDao().insert(data)
    }

    override suspend fun insertAll(dataList: List<LocalDataEntity>) {
        localDatabase.localDataDao().insertAll(dataList)
    }

}
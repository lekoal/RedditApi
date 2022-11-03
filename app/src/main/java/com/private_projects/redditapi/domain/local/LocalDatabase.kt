package com.private_projects.redditapi.domain.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.private_projects.redditapi.data.local.LocalDataEntity

@Database(entities = [LocalDataEntity::class], version = 1, exportSchema = true)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDataDao(): LocalDataDao
}
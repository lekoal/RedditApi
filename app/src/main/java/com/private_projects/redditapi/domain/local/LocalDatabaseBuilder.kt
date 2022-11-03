package com.private_projects.redditapi.domain.local

import android.content.Context
import androidx.room.Room

object LocalDatabaseBuilder {
    private var instance: LocalDatabase? = null

    fun getInstance(context: Context): LocalDatabase {
        if (instance == null) {
            synchronized(LocalDatabase::class) {
                instance = buildRoomDB(context)
            }
        }
        return instance!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            LocalDatabase::class.java,
            "localRedditDB"
        ).build()
}
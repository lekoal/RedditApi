package com.private_projects.redditapi

import android.app.Application
import com.private_projects.redditapi.di.mainKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(mainKoinModule)
        }
    }
}
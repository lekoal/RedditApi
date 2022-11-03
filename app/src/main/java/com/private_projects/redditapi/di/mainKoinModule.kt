package com.private_projects.redditapi.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.private_projects.redditapi.data.local.LocalDataRepoImpl
import com.private_projects.redditapi.data.local.LocalDatabaseHelperImpl
import com.private_projects.redditapi.data.remote.RedditDataApiHelper
import com.private_projects.redditapi.domain.local.LocalDataRepo
import com.private_projects.redditapi.domain.local.LocalDatabaseBuilder
import com.private_projects.redditapi.domain.local.LocalDatabaseHelper
import com.private_projects.redditapi.domain.remote.RedditDataApi
import com.private_projects.redditapi.ui.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainKoinModule = module {
    single(named("base_url")) { "https://www.reddit.com/r/memes/" }

    factory<Retrofit>(named("retrofit")) {
        Retrofit.Builder()
            .baseUrl(get<String>(named("base_url")))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named("local_database")) {
       LocalDatabaseBuilder.getInstance(androidContext())
    }

    single<LocalDatabaseHelper>(named("local_database_helper")) {
        LocalDatabaseHelperImpl(get(named("local_database")))
    }

    single(named("reddit_data_api")) {
        get<Retrofit>(named("retrofit")).create(RedditDataApi::class.java)
    }

    single(named("reddit_data_api_helper")) {
        RedditDataApiHelper(get(named("reddit_data_api")))
    }

    single<LocalDataRepo>(named("local_data_repo")) {
        LocalDataRepoImpl(get(named("local_database_helper")))
    }

    viewModel(named("main_view_model")) {
        MainViewModel(
            get(named("local_database_helper")),
            get(named("reddit_data_api_helper")),
            get(named("local_data_repo"))
        )
    }
}
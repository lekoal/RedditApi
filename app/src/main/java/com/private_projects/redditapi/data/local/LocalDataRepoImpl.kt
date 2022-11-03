package com.private_projects.redditapi.data.local

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.private_projects.redditapi.domain.local.LocalDataRepo
import com.private_projects.redditapi.domain.local.LocalDatabaseHelper

private const val NETWORK_PAGE_SIZE = 10

class LocalDataRepoImpl(
    private val localDatabaseHelper: LocalDatabaseHelper
) : LocalDataRepo {
    override fun getPosts(): LiveData<PagingData<LocalDataEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true,
                initialLoadSize = 5
            ),
            pagingSourceFactory = {
                LocalDataPagingSource(localDatabaseHelper)
            },
            initialKey = 1
        ).liveData
    }

}
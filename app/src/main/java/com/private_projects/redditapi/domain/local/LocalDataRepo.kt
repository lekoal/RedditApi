package com.private_projects.redditapi.domain.local

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.private_projects.redditapi.data.local.LocalDataEntity

interface LocalDataRepo {
    fun getPosts(): LiveData<PagingData<LocalDataEntity>>
}
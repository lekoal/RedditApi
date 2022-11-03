package com.private_projects.redditapi.data.local

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.private_projects.redditapi.domain.local.LocalDatabaseHelper

class LocalDataPagingSource(
    private val localDatabaseHelper: LocalDatabaseHelper
) : PagingSource<Int, LocalDataEntity>(){

    companion object {
        const val INITIAL_PAGE_INDEX = 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocalDataEntity> {
        val position = params.key ?: INITIAL_PAGE_INDEX
        val posts = localDatabaseHelper.getAll(params.loadSize)
        return LoadResult.Page(
            data = posts,
            prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
            nextKey = if (posts.isEmpty()) null else position + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, LocalDataEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
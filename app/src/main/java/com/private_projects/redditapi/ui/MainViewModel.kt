package com.private_projects.redditapi.ui

import androidx.lifecycle.ViewModel
import com.private_projects.redditapi.data.local.LocalDataEntity
import com.private_projects.redditapi.data.remote.RedditDataApiHelper
import com.private_projects.redditapi.domain.local.LocalDatabaseHelper
import kotlinx.coroutines.*

class MainViewModel(
    private val localDatabaseHelper: LocalDatabaseHelper,
    private val redditDataApiHelper: RedditDataApiHelper
    ) : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun getPosts() {
        coroutineScope.launch {
            val response = redditDataApiHelper.getPosts()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()?.data?.children?.forEach {
                        localDatabaseHelper.insert(
                            LocalDataEntity(
                                title = it.data.title,
                                popularity = it.data.score,
                                comments = it.data.numComments
                            )
                        )
                    }
                }
            }
        }
    }




    override fun onCleared() {
        coroutineScope.cancel()
        super.onCleared()
    }
}
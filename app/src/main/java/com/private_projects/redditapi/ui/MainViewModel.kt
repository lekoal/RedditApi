package com.private_projects.redditapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.private_projects.redditapi.data.local.LocalDataEntity
import com.private_projects.redditapi.data.remote.RedditDataApiHelper
import com.private_projects.redditapi.domain.local.LocalDataRepo
import com.private_projects.redditapi.domain.local.LocalDatabaseHelper
import kotlinx.coroutines.*

class MainViewModel(
    private val localDatabaseHelper: LocalDatabaseHelper,
    private val redditDataApiHelper: RedditDataApiHelper,
    private val localDataRepo: LocalDataRepo
) : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading


    fun getPosts() {
        coroutineScope.launch {
            _loading.postValue(true)
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
                } else {
                    _errorMessage.postValue(response.message())
                    _loading.postValue(false)
                }
            }
        }
    }

    private fun getLocalData(): LiveData<PagingData<LocalDataEntity>> {
        _loading.postValue(false)
        return localDataRepo.getPosts().cachedIn(viewModelScope)
    }

    override fun onCleared() {
        coroutineScope.cancel()
        super.onCleared()
    }
}
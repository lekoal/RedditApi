package com.private_projects.redditapi.data.remote

import com.private_projects.redditapi.domain.remote.RedditDataApi

class RedditDataApiHelper(private val redditDataApi: RedditDataApi) {
    suspend fun getPosts() = redditDataApi.getPosts()
}
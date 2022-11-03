package com.private_projects.redditapi.domain.remote

import com.private_projects.redditapi.data.remote.RedditData
import retrofit2.Response
import retrofit2.http.GET

interface RedditDataApi {
    @GET("hot.json")
    suspend fun getPosts(): Response<RedditData>
}
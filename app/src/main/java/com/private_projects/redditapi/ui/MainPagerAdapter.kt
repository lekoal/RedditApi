package com.private_projects.redditapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.private_projects.redditapi.data.local.LocalDataEntity
import com.private_projects.redditapi.databinding.RvPostsItemBinding

class MainPagerAdapter :
    PagingDataAdapter<LocalDataEntity, MainPagerAdapter.PostViewHolder>(PostComparator) {
    object PostComparator : DiffUtil.ItemCallback<LocalDataEntity>() {
        override fun areItemsTheSame(
            oldItem: LocalDataEntity,
            newItem: LocalDataEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LocalDataEntity,
            newItem: LocalDataEntity
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.title.text = post?.title
        holder.userScore.text = post?.popularity.toString()
        holder.commentsCount.text = post?.comments.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvPostsItemBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    inner class PostViewHolder(view: RvPostsItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        val title = view.postTitle
        val userScore = view.userScoreText
        val commentsCount = view.commentsCount
    }
}
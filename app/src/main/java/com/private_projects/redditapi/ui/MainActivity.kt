package com.private_projects.redditapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.private_projects.redditapi.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel(named("main_view_model"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPosts()
    }

}
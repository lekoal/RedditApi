package com.private_projects.redditapi.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.private_projects.redditapi.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel(named("main_view_model"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showProgress()
        viewModel.getPosts()
    }

    private fun showProgress() {
        viewModel.loading.observe(this) {
            loading(it)
        }
    }

    private fun loading(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingProcessLayout.visibility = View.VISIBLE
        } else {
            binding.loadingProcessLayout.visibility = View.GONE
        }
        binding.loadingProcessLayout.isClickable = isLoading
    }

}
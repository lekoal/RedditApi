package com.private_projects.redditapi.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.private_projects.redditapi.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel(named("main_view_model"))
    private val adapter: MainPagerAdapter by lazy {
        get(named("main_pager_adapter"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getPosts()
        initRV()
        showProgress()
        submitPosts()
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

    private fun initRV() {
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPosts.adapter = adapter
    }

    private fun submitPosts() {
        lifecycleScope.launch {
            viewModel.getLocalData().observe(this@MainActivity) {
                adapter.submitData(lifecycle, it)
            }
        }
    }

}
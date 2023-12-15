package com.example.cocktails.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.cocktails.R
import com.example.cocktails.application.App
import com.example.cocktails.presentation.main.MainFragment
import com.example.cocktails.base.Factory


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainActivityViewModel> {
        Factory {
            (AppCompatActivity().application as App)
                .getAppComponent()
                .getMainActivityViewModel()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment()
    }

    private fun openFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }

    override fun onDestroy() {
        viewModel.deleteCache()
        super.onDestroy()
    }
}
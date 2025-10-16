package com.example.myapplication.ui.features.reviewchampion

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ReviewChampionViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReviewChampionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ReviewChampionViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
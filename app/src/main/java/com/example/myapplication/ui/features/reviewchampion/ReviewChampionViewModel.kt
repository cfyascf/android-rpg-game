package com.example.myapplication.ui.features.reviewchampion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.ChampionCreationState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ReviewChampionViewModel : ViewModel() {
    fun onStartGameClicked() {
        val state = ChampionCreationState.getInstance()

    }
}
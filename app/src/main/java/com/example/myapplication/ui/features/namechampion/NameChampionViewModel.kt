package com.example.myapplication.ui.features.namechampion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.myapplication.domain.models.ChampionCreationState

class NameChampionViewModel {
    var championName by mutableStateOf("")

    fun nameCharacterAndMoveNext(onNavigateToModeSelectionScreen: () -> Unit) {
        val championCreationState = ChampionCreationState.newInstance()
        championCreationState?.name = championName

        onNavigateToModeSelectionScreen()
    }
}
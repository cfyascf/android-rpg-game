package com.example.myapplication.ui.features.selectarchetype

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.myapplication.domain.abstractions.ArchetypeOptions
import com.example.myapplication.domain.abstractions.RaceOptions
import com.example.myapplication.domain.models.ChampionCreationState

class SelectArchetypeViewModel {
    private val TAG = "SelectArchetypeViewModel"
    var selectedArchetype: ArchetypeOptions? by mutableStateOf(null)

    fun selectArchetypeAndMoveNext(
        selectedArchetype: ArchetypeOptions?, onMoveToReviewChampionScreen: () -> Unit
    ) {
        if(selectedArchetype == null) {
            return
        }

        val championCreationState = ChampionCreationState.getInstance()
        championCreationState.archetype = selectedArchetype

        Log.d(TAG, "selected archetype: $selectedArchetype")

        onMoveToReviewChampionScreen()
    }
}
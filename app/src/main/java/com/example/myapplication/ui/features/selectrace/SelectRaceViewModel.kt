package com.example.myapplication.ui.features.selectrace

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.myapplication.domain.abstractions.RaceOptions
import com.example.myapplication.domain.models.ChampionCreationState

class SelectRaceViewModel {
    private val TAG = "HeroicAttributeRollingViewModel"
    var selectedRace: RaceOptions? by mutableStateOf(null)

    fun selectRaceAndMoveNext(
        selectedRace: RaceOptions?, onMoveToSelectArchetypeScreen: () -> Unit
    ) {
        if(selectedRace == null) {
            return
        }

        val championCreationState = ChampionCreationState.getInstance()
        championCreationState.race = selectedRace

        Log.d(TAG, "selected race: $selectedRace")

        onMoveToSelectArchetypeScreen()
    }
}
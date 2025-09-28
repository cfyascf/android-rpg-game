package com.example.myapplication.ui.features.selectattributerollingmode

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.myapplication.domain.entities.AttributeRollingModes
import com.example.myapplication.domain.models.ChampionCreationState

class SelectAttributeRollingModeViewModel {
    var selectedMode: AttributeRollingModes? by mutableStateOf(null)

    fun selectModeAndMoveNext(
        selectedMode: AttributeRollingModes?, onMoveToModeSelectedScreen: (selectedMode: AttributeRollingModes) -> Unit)
    {
        if(selectedMode == null) {
            return
        }

        val championCreationState = ChampionCreationState.getInstance()
        championCreationState.mode = selectedMode
        System.out.println(selectedMode)

        onMoveToModeSelectedScreen(selectedMode)
    }
}
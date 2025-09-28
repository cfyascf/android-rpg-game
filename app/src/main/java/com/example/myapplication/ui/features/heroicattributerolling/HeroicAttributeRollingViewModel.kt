package com.example.myapplication.ui.features.heroicattributerolling

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.entities.Dice
import com.example.myapplication.domain.models.ChampionCreationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HeroicAttributeRollingViewModel : ViewModel() {
    private val TAG = "HeroicAttributeRollingViewModel"
    private val _uiState = MutableStateFlow(HeroicScreenState())
    val uiState: StateFlow<HeroicScreenState> = _uiState.asStateFlow()

    fun rollDices() {
        val scores = Dice.roll4d6()
        _uiState.update {
            it.copy(
                rolledScores = scores,
                unassignedScores = scores.toMutableList(),
                strength = null, dexterity = null, constitution = null,
                intelligence = null, wisdom = null, charism = null
            )
        }
    }

    fun selectScore(score: Int) {
        _uiState.update {
            it.copy(selectedScore = if (it.selectedScore == score) null else score)
        }
    }

    fun assignScoreToAttribute(attributeName: String) {
        val selected = _uiState.value.selectedScore ?: return

        _uiState.update { currentState ->
            val unassigned = currentState.unassignedScores.toMutableList()
            unassigned.remove(selected)

            val currentAttributeValue = when (attributeName) {
                "Strength" -> currentState.strength
                "Dexterity" -> currentState.dexterity
                "Constitution" -> currentState.constitution
                "Intelligence" -> currentState.intelligence
                "Wisdom" -> currentState.wisdom
                "Charism" -> currentState.charism
                else -> null
            }
            currentAttributeValue?.let { unassigned.add(it) }

            val newState = when (attributeName) {
                "Strength" -> currentState.copy(strength = selected)
                "Dexterity" -> currentState.copy(dexterity = selected)
                "Constitution" -> currentState.copy(constitution = selected)
                "Intelligence" -> currentState.copy(intelligence = selected)
                "Wisdom" -> currentState.copy(wisdom = selected)
                "Charism" -> currentState.copy(charism = selected)
                else -> currentState
            }

            newState.copy(
                unassignedScores = unassigned.sortedDescending(),
                selectedScore = null
            )
        }
    }

    fun setAttributesAndMoveNext(onNavigateToRaceSelectionScreen: () -> Unit) {
        val championCreationState = ChampionCreationState.getInstance()
        championCreationState.strength = _uiState.value.strength
        championCreationState.dexterity = _uiState.value.dexterity
        championCreationState.constitution = _uiState.value.constitution
        championCreationState.intelligence = _uiState.value.intelligence
        championCreationState.wisdom = _uiState.value.wisdom
        championCreationState.charism = _uiState.value.charism

        Log.d(TAG, "selected attributes -> " +
                "str: [${championCreationState.strength}] " +
                "dex: [${championCreationState.dexterity}] " +
                "con: [${championCreationState.constitution}] " +
                "int: [${championCreationState.intelligence}] " +
                "wis: [${championCreationState.wisdom}] " +
                "cha: [${championCreationState.charism}] " +
                "")


        onNavigateToRaceSelectionScreen()
    }
}
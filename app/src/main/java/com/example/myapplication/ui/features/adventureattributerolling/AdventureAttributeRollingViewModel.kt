package com.example.myapplication.ui.features.adventureattributerolling

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.entities.Dice
import com.example.myapplication.domain.models.ChampionCreationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
class AdventureAttributeRollingViewModel : ViewModel() {
    private val TAG = "AdventureAttributeRollingViewModel"

    // useState do react, estado mutavel e observavel
    private val _uiState = MutableStateFlow(AdventureScreenState())

    // estado em modo readonly
    val uiState: StateFlow<AdventureScreenState> = _uiState.asStateFlow()


    fun rollDices() {
        val scores = Dice.roll3d6()
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
        // se o estado for o mesmo, deseleciona a opcao
        _uiState.update {
            it.copy(selectedScore = if (it.selectedScore == score) null else score)
        }
    }

    fun assignScoreToAttribute(attributeName: String) {

        // se nao houver estado selecionado, retorna
        val selected = _uiState.value.selectedScore ?: return

        _uiState.update { currentState ->

            // remove o valor selecionado das opcoes
            val unassigned = currentState.unassignedScores.toMutableList()
            unassigned.remove(selected)

            // acha o valor atual do atributo
            val currentAttributeValue = when (attributeName) {
                "Strength" -> currentState.strength
                "Dexterity" -> currentState.dexterity
                "Constitution" -> currentState.constitution
                "Intelligence" -> currentState.intelligence
                "Wisdom" -> currentState.wisdom
                "Charism" -> currentState.charism
                else -> null
            }

            // volta o valor pra lista de opcoes
            currentAttributeValue?.let { unassigned.add(it) }

            // atualiza os valores selecionados
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
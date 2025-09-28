package com.example.myapplication.domain.models

import com.example.myapplication.domain.entities.AttributeRollingModes

data class ChampionCreationState(
    var name: String? = null,
    var mode: AttributeRollingModes? = null,
    var strength: Int? = null,
    var dexterity: Int? = null,
    var constitution: Int? = null,
    var intelligence: Int? = null,
    var wisdom: Int? = null,
    var charism: Int? = null,
) {
    companion object {
        @Volatile
        private var INSTANCE: ChampionCreationState? = null

        fun getInstance(): ChampionCreationState =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: ChampionCreationState().also { INSTANCE = it }
            }

        fun newInstance(): ChampionCreationState? {
            INSTANCE = ChampionCreationState()
            return INSTANCE
        }
    }
}
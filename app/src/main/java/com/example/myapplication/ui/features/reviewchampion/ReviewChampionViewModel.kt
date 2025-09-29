package com.example.myapplication.ui.features.reviewchampion

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.abstractions.Race
import com.example.myapplication.domain.entities.Champion
import com.example.myapplication.domain.entities.Game
import com.example.myapplication.domain.models.ChampionCreationState
import kotlinx.coroutines.flow.StateFlow

class ReviewChampionViewModel : ViewModel() {

    val creationState: ChampionCreationState = ChampionCreationState.getInstance()

    fun createChampion() {
        if(creationState.archetype == null || creationState.strength == null || creationState.dexterity == null || creationState.constitution == null ||
            creationState.intelligence == null || creationState.wisdom == null || creationState.charism == null || creationState.race == null || creationState.name == null) {
            throw IllegalArgumentException("The parameters for building champion are invalid.")
        }

        val race = Race.fromRaceOption(creationState.race)
        val archetype = Archetype.fromArchetypeOption(
            creationState.archetype!!,
            creationState.strength!!,
            creationState.dexterity!!,
            creationState.constitution!!,
            creationState.intelligence!!,
            creationState.wisdom!!,
            creationState.charism!!)

        val champion = Champion(creationState.name!!, race, archetype)
        Game.getCurrentGame().setChampion(champion)
    }
}
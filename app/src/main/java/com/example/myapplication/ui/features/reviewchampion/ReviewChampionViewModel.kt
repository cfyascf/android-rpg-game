package com.example.myapplication.ui.features.reviewchampion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.abstractions.Race
import com.example.myapplication.domain.context.AppDatabase
import com.example.myapplication.domain.entities.Champion
import com.example.myapplication.domain.entities.Game
import com.example.myapplication.domain.models.ChampionCreationState
import com.example.myapplication.domain.repositories.ChampionRepository
import kotlinx.coroutines.launch

class ReviewChampionViewModel(application: Application) : AndroidViewModel(application) {
    private val championRepository = ChampionRepository(
        AppDatabase.getDatabase(application).championDao())
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

        val champion = Champion(name = creationState.name!!, race = race, archetype = archetype)
        Game.getCurrentGame().setChampion(champion)

        viewModelScope.launch {
            championRepository.insert(champion)
        }
    }
}
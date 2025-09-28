package com.example.myapplication.domain.entities

import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.abstractions.Race

open class Champion(
    val name: String,
    val race: Race,
    val archetype: Archetype
) {
    companion object {
        fun createChampion(
            name: String,
            race: Race,
            archetype: Archetype
        ): Champion? {

            return Champion(name, race, archetype)
        }
    }

    override fun toString(): String {
        return "Champion(" +
                "strength=${archetype.strength}, " +
                "dexterity=${archetype.dexterity}, " +
                "constitution=${archetype.constitution}, " +
                "intelligence=${archetype.intelligence}, " +
                "wisdom=${archetype.wisdom}, " +
                "charisma=${archetype.charisma}, " +
                "race=$race, " +
                "archetype=${archetype::class.simpleName}" +
                ")"
    }
}
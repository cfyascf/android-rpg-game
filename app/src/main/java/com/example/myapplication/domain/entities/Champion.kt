package com.example.myapplication.domain.entities

import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.abstractions.IArchetypeFactory
import com.example.myapplication.domain.abstractions.Race

open class Champion(
    val name: String,
    val archetype: Archetype,
    val race: Race,
) {
    companion object {
        fun createChampion(
            name: String,
            archetypeFactory: IArchetypeFactory<out Archetype>,
            race: Race,
            diceType: String,
            heroicAttributes: List<Int>? = null
        ): Champion? {
            val archetype = archetypeFactory.createArchetype(diceType, heroicAttributes) ?: return null
            return Champion(name, archetype, race)
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
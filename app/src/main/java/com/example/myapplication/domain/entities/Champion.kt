package com.example.myapplication.domain.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.abstractions.IArchetypeFactory
import com.example.myapplication.domain.abstractions.Race

@Entity(tableName = "Champion")
data class Champion(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,

    @Embedded
    val archetype: Archetype,

    @Embedded
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
            return Champion(name = name, archetype = archetype, race = race)
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
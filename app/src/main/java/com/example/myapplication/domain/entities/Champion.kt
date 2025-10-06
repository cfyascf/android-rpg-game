package com.example.myapplication.domain.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.abstractions.Race

@Entity(tableName = "Champion")
open class Champion(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,

    @Embedded
    val race: Race,

    @Embedded
    val archetype: Archetype
) {
    companion object {
        fun createChampion(
            name: String,
            race: Race,
            archetype: Archetype
        ): Champion? {

            return Champion(name = name, race = race, archetype = archetype)
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
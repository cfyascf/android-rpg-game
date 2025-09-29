package com.example.myapplication.domain.entities.archetypes

import android.health.connect.datatypes.units.Power
import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Dice
import com.example.myapplication.domain.entities.Powers
import com.example.myapplication.domain.entities.WeaponType

class Archer(
    strength: Int,
    dexterity: Int,
    constitution: Int,
    intelligence: Int,
    wisdom: Int,
    charism: Int,
    weapons: MutableList<WeaponType>,
    armors: MutableList<ArmorType>,
    powers: MutableList<Powers>
) : Archetype(strength, dexterity, constitution, intelligence, wisdom, charism, weapons, armors, powers) {
    companion object {
        fun BuildArcher(
            strength: Int, dexterity: Int, constitution: Int, intelligence: Int,
            wisdom: Int, charism: Int
        ): Archer {
            val weapons = mutableListOf<WeaponType>(
                WeaponType.CROSSBOW, WeaponType.BOW, WeaponType.SLING)

            val armors = mutableListOf<ArmorType>(
                ArmorType.NONE, ArmorType.MEDIUM, ArmorType.SHIELD
            )

            val powers = mutableListOf<Powers>(
                Powers.FLASH
            )

            return Archer(strength, dexterity, constitution, intelligence,
                wisdom, charism, weapons, armors, powers)
        }
    }
}
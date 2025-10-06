package com.example.myapplication.domain.entities.archetypes

import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Dice
import com.example.myapplication.domain.entities.Powers
import com.example.myapplication.domain.entities.WeaponType

class Mage(
    strength: Int,
    dexterity: Int,
    constitution: Int,
    intelligence: Int,
    wisdom: Int,
    charism: Int,
    weapons: MutableList<WeaponType>,
    armors: MutableList<ArmorType>,
    powers: MutableList<Powers>
) : Archetype(strength, dexterity, constitution, intelligence, wisdom, charism, weapons, armors, powers
) {
    companion object {
        fun BuildMage(
            strength: Int, dexterity: Int, constitution: Int, intelligence: Int,
            wisdom: Int, charism: Int
        ): Mage {
            val weapons = mutableListOf<WeaponType>(
                WeaponType.STAFF, WeaponType.SLING)

            val armors = mutableListOf<ArmorType>(
                ArmorType.NONE, ArmorType.LIGHT
            )

            val powers = mutableListOf<Powers>(
                Powers.FLASH, Powers.IGNITE, Powers.HEAL
            )

            return Mage(strength, dexterity, constitution, intelligence,
                wisdom, charism, weapons, armors, powers)
        }
    }
}
package com.example.myapplication.domain.entities.archetypes

import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Powers
import com.example.myapplication.domain.entities.WeaponType

class Warrior(
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
        fun BuildWarrior(
            strength: Int, dexterity: Int, constitution: Int, intelligence: Int,
            wisdom: Int, charism: Int
        ): Warrior {
            val weapons = mutableListOf<WeaponType>(
                WeaponType.CLUB, WeaponType.MACE, WeaponType.HAMMER)

            val armors = mutableListOf<ArmorType>(
                ArmorType.NONE, ArmorType.HEAVY, ArmorType.SHIELD
            )

            val powers = mutableListOf<Powers>(
                Powers.HEAL
            )

            return Warrior(strength, dexterity, constitution, intelligence,
                wisdom, charism, weapons, armors, powers)
        }
    }
}
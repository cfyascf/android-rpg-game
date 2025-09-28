package com.example.myapplication.domain.abstractions

import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.WeaponType
import com.example.myapplication.domain.entities.archetypes.Archer

abstract class Archetype(
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val weapons: MutableList<WeaponType>,
    val armors: MutableList<ArmorType>,
    val powers: MutableList<String>
) {
    companion object {
        fun fromArchetypeOption(
            option: ArchetypeOptions, strength: Int, dexterity: Int,
            constitution: Int, intelligence: Int, wisdom: Int, charism: Int
        ) {
            return when(option) {
                ArchetypeOptions.ARCHER -> Archer(strength, dexterity, constitution, intelligence, wisdom, charism)
            }
        }
    }
}

enum class ArchetypeOptions {
    ARCHER,
    MAGE,
    WARRIOR
}
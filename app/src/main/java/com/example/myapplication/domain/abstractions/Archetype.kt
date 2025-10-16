package com.example.myapplication.domain.abstractions

import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Powers
import com.example.myapplication.domain.entities.WeaponType
import com.example.myapplication.domain.entities.archetypes.Archer
import com.example.myapplication.domain.entities.archetypes.Mage
import com.example.myapplication.domain.entities.archetypes.Warrior
import kotlinx.serialization.Serializable

@Serializable
abstract class Archetype {
    abstract var strength: Int
    abstract var dexterity: Int
    abstract var constitution: Int
    abstract var intelligence: Int
    abstract var wisdom: Int
    abstract var charism: Int
    abstract var weapons: MutableList<WeaponType>
    abstract var armors: MutableList<ArmorType>
    abstract var powers: MutableList<Powers>
    companion object {
        fun fromArchetypeOption(
            option: ArchetypeOptions, strength: Int, dexterity: Int,
            constitution: Int, intelligence: Int, wisdom: Int, charism: Int
        ): Archetype {
            return when(option) {
                ArchetypeOptions.ARCHER -> Archer.BuildArcher(strength, dexterity, constitution, intelligence, wisdom, charism)
                ArchetypeOptions.MAGE -> Mage.BuildMage(strength, dexterity, constitution, intelligence, wisdom, charism)
                ArchetypeOptions.WARRIOR -> Warrior.BuildWarrior(strength, dexterity, constitution, intelligence, wisdom, charism)
            }
        }
    }
}

enum class ArchetypeOptions {
    ARCHER,
    MAGE,
    WARRIOR
}
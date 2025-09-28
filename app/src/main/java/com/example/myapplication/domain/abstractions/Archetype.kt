package com.example.myapplication.domain.abstractions

import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.WeaponType

open class Archetype(
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val weapons: MutableList<WeaponType>,
    val armors: MutableList<ArmorType>,
    val powers: MutableList<String>
)

enum class ArchetypeOptions {
    ARCHER,
    MAGE,
    WARRIOR
}
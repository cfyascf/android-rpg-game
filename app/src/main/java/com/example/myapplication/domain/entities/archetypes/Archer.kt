package com.example.myapplication.domain.entities.archetypes

import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.abstractions.IArchetypeFactory
import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Dice
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
    powers: MutableList<String>
) : Archetype(strength, dexterity, constitution, intelligence, wisdom, charism, weapons, armors, powers)
package com.example.myapplication.domain.entities.archetypes

import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Powers
import com.example.myapplication.domain.entities.WeaponType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Archer")
class Archer(
    override var strength: Int,
    override var dexterity: Int,
    override var constitution: Int,
    override var intelligence: Int,
    override var wisdom: Int,
    override var charism: Int,
    override var weapons: MutableList<WeaponType>,
    override var armors: MutableList<ArmorType>,
    override var powers: MutableList<Powers>
) : Archetype() {
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
package com.example.myapplication.domain.entities.races

import com.example.myapplication.domain.abstractions.Race
import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Powers
import com.example.myapplication.domain.entities.WeaponType
import com.example.myapplication.domain.entities.archetypes.Archer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Dwarf")
class Dwarf(
    override var moviment: Int = 6,
    override var infravision: Int = 18,
    override var alignment: String = "comply"
): Race() {

}
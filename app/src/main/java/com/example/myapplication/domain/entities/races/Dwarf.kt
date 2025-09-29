package com.example.myapplication.domain.entities.races

import com.example.myapplication.domain.abstractions.Race
import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Powers
import com.example.myapplication.domain.entities.WeaponType
import com.example.myapplication.domain.entities.archetypes.Archer

class Dwarf(
    moviment: Int = 6,
    infravision: Int = 18,
    alignment: String = "comply"): Race(moviment, infravision, alignment
    ) {
}
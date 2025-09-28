package com.example.myapplication.domain.entities.races

import com.example.myapplication.domain.abstractions.Race

class Dwarf(
    moviment: Int = 6,
    infravision: Int = 18,
    alignment: String = "comply"): Race(moviment, infravision, alignment) {
}
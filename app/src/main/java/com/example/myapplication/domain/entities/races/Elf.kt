package com.example.myapplication.domain.entities.races

import com.example.myapplication.domain.abstractions.Race

class Elf(
    moviment: Int = 9,
    infravision: Int = 18,
    alignment: String = "neutral"): Race(moviment, infravision, alignment) {
}
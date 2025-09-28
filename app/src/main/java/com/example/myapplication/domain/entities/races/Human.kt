package com.example.myapplication.domain.entities.races

import com.example.myapplication.domain.abstractions.Race

class Human(
    moviment: Int = 9,
    infravision: Int = 0,
    alignment: String = "any"): Race(moviment, infravision, alignment) {
}
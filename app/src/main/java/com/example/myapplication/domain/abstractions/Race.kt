package com.example.myapplication.domain.abstractions

import com.example.myapplication.domain.entities.races.Dwarf
import com.example.myapplication.domain.entities.races.Elf
import com.example.myapplication.domain.entities.races.Human

abstract class Race(
    var moviment: Int,
    var infravision: Int,
    var alignment: String
){

    companion object {
        fun fromRaceOption(option: RaceOptions): Race {
            return when(option) {
                RaceOptions.ELF -> Elf()
                RaceOptions.DWARF -> Dwarf()
                RaceOptions.HUMAN -> Human()
            }
        }
    }
}

enum class RaceOptions {
    DWARF,
    ELF,
    HUMAN
}
package com.example.myapplication.domain.abstractions

import com.example.myapplication.domain.entities.races.Dwarf
import com.example.myapplication.domain.entities.races.Elf
import com.example.myapplication.domain.entities.races.Human
import kotlinx.serialization.Serializable

@Serializable
abstract class Race {
    abstract var moviment: Int
    abstract var infravision: Int
    abstract var alignment: String

    companion object {
        fun fromRaceOption(option: RaceOptions?): Race {
            if(option == null) {
                return Elf()
            }

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
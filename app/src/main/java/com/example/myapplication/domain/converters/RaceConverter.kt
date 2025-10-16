package com.example.myapplication.domain.converters

import androidx.room.TypeConverter
import com.example.myapplication.domain.abstractions.Race
import com.example.myapplication.domain.entities.races.Dwarf
import com.example.myapplication.domain.entities.races.Elf
import com.example.myapplication.domain.entities.races.Human

class RaceConverter {
    @TypeConverter
    fun fromRace(race: Race): String {
        return race.toString()
    }

    @TypeConverter
    fun toRace(raceName: String): Race {
        return when (raceName) {
            "Human" -> Human()
            "Elf" -> Elf()
            "Dwarf" -> Dwarf()
            else -> throw IllegalArgumentException("Unknown race name: $raceName")
        }
    }
}
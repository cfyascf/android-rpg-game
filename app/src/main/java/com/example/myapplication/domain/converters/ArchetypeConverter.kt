package com.example.myapplication.domain.converters

import androidx.room.TypeConverter
import com.example.myapplication.domain.abstractions.Archetype
import kotlinx.serialization.encodeToString

class ArchetypeConverter {
    @TypeConverter
    fun fromArchetype(archetype: Archetype?): String? {
        return archetype?.let { AppJson.instance.encodeToString(it) }
    }

    @TypeConverter
    fun toArchetype(archetypeString: String?): Archetype? {
        return archetypeString?.let { AppJson.instance.decodeFromString<Archetype>(it) }
    }
}
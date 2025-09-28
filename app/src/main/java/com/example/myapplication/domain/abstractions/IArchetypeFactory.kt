package com.example.myapplication.domain.abstractions

import com.example.myapplication.domain.abstractions.Archetype

interface IArchetypeFactory<T : Archetype> {
    fun createArchetype(diceType: String, heroicAttributes: List<Int>? = null): T?
}
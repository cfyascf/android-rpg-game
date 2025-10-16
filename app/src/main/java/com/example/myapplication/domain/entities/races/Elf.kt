package com.example.myapplication.domain.entities.races

import com.example.myapplication.domain.abstractions.Race
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Elf")
class Elf(
    override var moviment: Int = 9,
    override var infravision: Int = 18,
    override var alignment: String = "neutral"
): Race() {

}
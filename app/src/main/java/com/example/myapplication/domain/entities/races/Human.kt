package com.example.myapplication.domain.entities.races

import com.example.myapplication.domain.abstractions.Race
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Human")
class Human(
    override var moviment: Int = 9,
    override var infravision: Int = 0,
    override var alignment: String = "any"
): Race() {

}
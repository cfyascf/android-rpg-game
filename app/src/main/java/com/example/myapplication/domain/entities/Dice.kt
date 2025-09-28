package com.example.myapplication.domain.entities

import kotlin.random.Random

class Dice {
    companion object {
        const val NUMBER_OF_ATTRIBUTES = 6

        fun roll3d6(): MutableList<Int> {
            var attributeValues = mutableListOf<Int>()
            for (i in 1..NUMBER_OF_ATTRIBUTES) {
                attributeValues.add(attributeFor3d6())
            }

            return attributeValues
        }

        fun attributeFor3d6(): Int {

            var finalValue = 0
            val parts = "3d6".split("d")
            val rounds = parts[0].toInt()
            val sides = parts[1].toInt()
            for (round in 1..rounds) {
                val value = Random.nextInt(1, sides)
                finalValue += value
            }
            return finalValue
        }

        fun roll4d6(): MutableList<Int> {
            var attributeValues = mutableListOf<Int>()
            for (i in 1..NUMBER_OF_ATTRIBUTES) {
                attributeValues.add(attributeFor4d6())
            }

            return attributeValues
        }


        fun attributeFor4d6(): Int {
            val sortedNum = mutableListOf<Int>()
            val parts = "4d6".split("d")
            val rounds = parts[0].toInt()
            val sides = parts[1].toInt()
            for (round in 1..rounds) {
                val value = Random.nextInt(1, sides)
                sortedNum.add(value)
            }
            //println("antes do sort ${sortedNum.toString()}")
            sortedNum.sort()
            //println("depois do sort ${sortedNum.toString()}")
            sortedNum.removeAt(0)
            //println("sem o menor num ${sortedNum.toString()}")
            val finalValue = sortedNum.sum()
            //println("soma do sort $finalValue")
            return finalValue
        }
    }
}
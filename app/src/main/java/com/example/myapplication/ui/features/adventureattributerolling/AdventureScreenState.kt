package com.example.myapplication.ui.features.adventureattributerolling

data class AdventureScreenState(
    val rolledScores: List<Int> = emptyList(),
    val unassignedScores: List<Int> = emptyList(),
    val selectedScore: Int? = null,
    val strength: Int? = null,
    val dexterity: Int? = null,
    val constitution: Int? = null,
    val intelligence: Int? = null,
    val wisdom: Int? = null,
    val charism: Int? = null
) {
    val isAssignmentComplete: Boolean
        get() = strength != null && dexterity != null && constitution != null &&
                intelligence != null && wisdom != null && charism != null
}

package com.sabredg.android.foodtrail.model

data class Chosen(
    val chosen: MutableList<Choice>
) {
    fun addChoice(choice: Choice): Chosen {
        val updatedChosen = chosen.toMutableList().apply { add(choice) }
        return copy(chosen = updatedChosen)
    }

    fun removeChoice(choice: Choice): Chosen {
        val updatedChosen = chosen.toMutableList().apply { remove(choice) }
        return copy(chosen = updatedChosen)
    }
}
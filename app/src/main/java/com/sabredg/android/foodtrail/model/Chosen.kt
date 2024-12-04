package com.sabredg.android.foodtrail.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chosen(
    val chosen: MutableList<Choice> = mutableListOf()
) : Parcelable {
    val chosenList: List<Choice>
        get() = chosen.toList()

    fun addChoice(choice: Choice): Chosen {
        val updatedChosen = chosen.toMutableList().apply { add(choice) }
        return copy(chosen = updatedChosen)
    }

    fun removeChoice(choice: Choice): Chosen {
        val updatedChosen = chosen.toMutableList().apply { remove(choice) }
        return copy(chosen = updatedChosen)
    }
}
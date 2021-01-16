/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.skarlet.gis.data.Character
import ua.skarlet.gis.data.enumeration.Element

class CharactersViewModel : ViewModel() {

    val characters = MutableLiveData<List<Character>>()

    init {
        characters.value = createCharacters()
    }

    private fun createCharacters(): List<Character> {
        val tartaglia = Character(
            "Tartaglia",
            80,
            Element.HYDRO,
            12182,
            790,
            757,
            elementalDamageBonus = 28.8f
        )
        return listOf(tartaglia)
    }
}
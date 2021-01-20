/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ua.skarlet.gis.data.enumeration.Vision
import ua.skarlet.gis.db.character.Character
import ua.skarlet.gis.repo.CharacterRepository
import ua.skarlet.gis.ui.BaseViewModel

class CharactersViewModel : BaseViewModel() {

    private val repo = CharacterRepository(viewModelScope, db.characterDao())

    val characters: LiveData<List<Character>> = repo.getAll()

//    init {
//        val item = createCharacters()[0]
//        characters.value?.let { items ->
//            if (items.find { it.name == item.name } == null) {
//                repo.insert(item)
//            }
//        }
//    }

    private fun createCharacters(): List<Character> {
        val tartaglia = Character(
            "Tartaglia",
            80,
            Vision.HYDRO,
            12182,
            790,
            757,
            elementalDamageBonus = 28.8f
        )
        val ganyu = Character(
            "Ganyu",
            80,
            Vision.CRYO,
            9108,
            735,
            586,
            critDamage = 88.4f
        )
        return listOf(tartaglia, ganyu)
    }

    fun removeItem(position: Int) {
        repo.delete(characters.value!![position])
    }
}
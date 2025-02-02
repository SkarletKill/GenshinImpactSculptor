/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character.one

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ua.skarlet.gis.data.Stat
import ua.skarlet.gis.data.enumeration.Vision
import ua.skarlet.gis.db.character.Character
import ua.skarlet.gis.repo.CharacterRepository
import ua.skarlet.gis.ui.BaseViewModel

class NewCharacterViewModel : BaseViewModel() {

    private val repo = CharacterRepository(viewModelScope, db.characterDao())

    // data binding
    val characterName = MutableLiveData<String>()
    val level = MutableLiveData<String>()
    val vision = MutableLiveData(Vision.PYRO)
    val baseHP = MutableLiveData<String>()
    val baseATK = MutableLiveData<String>()
    val baseDEF = MutableLiveData<String>()
    val elementalMastery = MutableLiveData(Stat.ElementalMastery().value.toString())
    val critRate = MutableLiveData(Stat.CritRate().value.toString())
    val critDamage = MutableLiveData(Stat.CritDMG().value.toString())
    val elementalDamageBonus = MutableLiveData(Stat.ElementalDMG(vision.value!!).value.toString())

    fun createItem() {
        val character = Character(
            name = characterName.value!!,
            level = level.value!!.toInt(),
            vision = vision.value!!,
            baseHP = baseHP.value!!.toInt(),
            baseATK = baseATK.value!!.toInt(),
            baseDEF = baseDEF.value!!.toInt(),
            elementalMastery = elementalMastery.value!!.toInt(),
            critRate = critRate.value!!.toFloat(),
            critDamage = critDamage.value!!.toFloat(),
            elementalDamageBonus = elementalDamageBonus.value!!.toFloat()
        )
//        repo.insert(character)
    }
}
/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character.one

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import ua.skarlet.gis.data.Stat
import ua.skarlet.gis.data.enumeration.Vision
import ua.skarlet.gis.db.character.Character
import ua.skarlet.gis.repo.CharacterRepository
import ua.skarlet.gis.ui.BaseViewModel
import kotlin.random.Random

class NewCharacterViewModel : BaseViewModel() {

    private val repo = CharacterRepository(viewModelScope, db.characterDao())

    val characters: LiveData<List<Character>> = repo.getAll().also {
        it.observeForever {
            Log.d("NewCharacterViewModel", "Characters size: ${it.size}")
        }
    }

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

    fun saveItem(): Job {
        val character = Character(
            name = characterName.value ?: "Character ${Random.nextInt(Int.MAX_VALUE)}",
            level = level.value?.toInt() ?: Stat.Level().value,
            vision = vision.value ?: Vision.PYRO,
            baseHP = baseHP.value?.toInt() ?: Stat.HP().value,
            baseATK = baseATK.value?.toInt() ?: Stat.ATK().value,
            baseDEF = baseDEF.value?.toInt() ?: Stat.DEF().value,
            elementalMastery = elementalMastery.value?.toInt() ?: Stat.ElementalMastery().value,
            critRate = critRate.value?.toFloat() ?: Stat.CritRate().value,
            critDamage = critDamage.value?.toFloat() ?: Stat.CritDMG().value,
            elementalDamageBonus = elementalDamageBonus.value?.toFloat()
                ?: Stat.ElementalDMG(vision.value ?: Vision.PYRO).value
        )
        return repo.insert(character)
    }
}
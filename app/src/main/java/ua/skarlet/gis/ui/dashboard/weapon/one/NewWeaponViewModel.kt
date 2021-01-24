/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.weapon.one

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import ua.skarlet.gis.data.Stat
import ua.skarlet.gis.data.enumeration.WeaponType
import ua.skarlet.gis.db.weapon.Weapon
import ua.skarlet.gis.repo.WeaponRepository
import ua.skarlet.gis.ui.BaseViewModel
import kotlin.random.Random

class NewWeaponViewModel : BaseViewModel() {

    private val repo = WeaponRepository(viewModelScope, db.weaponDao())

    // data binding
    val weaponType = MutableLiveData(WeaponType.SWORD)
    val weaponName = MutableLiveData<String>()
    val level = MutableLiveData<String>()
    val baseATK = MutableLiveData<String>()
    val subStat = MutableLiveData(Stat.ATK_RATE())
    val subStatValue = MutableLiveData(subStat.value!!.value.toString())
//    val abilities: List<WeaponAbility>

    fun saveItem(): Job {
        val weapon = Weapon(
            type = weaponType.value ?: WeaponType.SWORD,
            name = weaponName.value ?: "Weapon ${Random.nextInt(Int.MAX_VALUE)}",
            level = level.value?.toInt() ?: Stat.Level().value,
            baseATK = baseATK.value?.toInt() ?: Stat.ATK().value,
            subStat = subStat.value ?: Stat.ATK_RATE(),
            subStatRate = subStatValue.value?.toFloat() ?: Stat.ATK_RATE().value
        )
        return repo.insert(weapon)
    }
}
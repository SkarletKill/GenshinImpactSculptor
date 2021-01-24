/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.weapon

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ua.skarlet.gis.db.weapon.Weapon
import ua.skarlet.gis.repo.WeaponRepository
import ua.skarlet.gis.ui.BaseViewModel

class WeaponsViewModel : BaseViewModel() {

    private val repo = WeaponRepository(viewModelScope, db.weaponDao())

    val weapons: LiveData<List<Weapon>> = repo.getAll()

    fun removeItem(position: Int) {
        repo.delete(weapons.value!![position])
    }
}
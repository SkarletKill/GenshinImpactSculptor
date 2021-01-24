/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.weapon

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ua.skarlet.gis.db.BaseDao
import ua.skarlet.gis.db.constants.BY_ID
import ua.skarlet.gis.db.constants.SELECT_ALL
import ua.skarlet.gis.db.constants.Table.WEAPONS

@Dao
interface WeaponDao : BaseDao<Weapon> {
    @Query("$SELECT_ALL $WEAPONS")
    override fun getAll(): LiveData<List<Weapon>>

    @Query("$SELECT_ALL $WEAPONS $BY_ID")
    override fun getById(itemId: Int) : LiveData<Weapon>
}
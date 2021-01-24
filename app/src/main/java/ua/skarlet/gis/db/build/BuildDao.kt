/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.build

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ua.skarlet.gis.db.BaseDao
import ua.skarlet.gis.db.constants.BY_ID
import ua.skarlet.gis.db.constants.SELECT_ALL
import ua.skarlet.gis.db.constants.Table.BUILDS

@Dao
interface BuildDao : BaseDao<Build> {
    @Query("$SELECT_ALL $BUILDS")
    override fun getAll(): LiveData<List<Build>>

    @Query("$SELECT_ALL $BUILDS $BY_ID")
    override fun getById(itemId: Int) : LiveData<Build>
}
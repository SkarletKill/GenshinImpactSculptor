/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.artifact

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ua.skarlet.gis.db.BaseDao
import ua.skarlet.gis.db.constants.BY_ID
import ua.skarlet.gis.db.constants.SELECT_ALL
import ua.skarlet.gis.db.constants.Table.ARTIFACTS

@Dao
interface ArtifactDao : BaseDao<Artifact> {
    @Query("$SELECT_ALL $ARTIFACTS")
    override fun getAll(): LiveData<List<Artifact>>

    @Query("$SELECT_ALL $ARTIFACTS $BY_ID")
    override fun getById(itemId: Int) : LiveData<Artifact>
}
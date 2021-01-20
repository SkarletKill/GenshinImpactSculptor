/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BaseDao<Entity> {
    fun getAll(): LiveData<List<Entity>>

    fun getById(itemId: Int) : LiveData<Entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Entity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: Entity)

    @Delete
    suspend fun delete(item: Entity)
}
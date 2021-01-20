/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.repo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ua.skarlet.gis.db.BaseDao

abstract class BaseRepository<Entity>(
    private val scope: CoroutineScope,
    private val dao: BaseDao<Entity>
) {
    fun getAll() = dao.getAll()

    fun getById(itemId: Int) = dao.getById(itemId)

    fun insert(item: Entity) = scope.launch {
        dao.insert(item)
    }

    fun update(item: Entity) = scope.launch {
        dao.update(item)
    }

    fun delete(item: Entity) = scope.launch {
        dao.delete(item)
    }
}
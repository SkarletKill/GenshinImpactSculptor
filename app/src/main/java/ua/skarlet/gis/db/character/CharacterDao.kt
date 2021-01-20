/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.character

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ua.skarlet.gis.db.BaseDao
import ua.skarlet.gis.db.constants.BY_ID
import ua.skarlet.gis.db.constants.SELECT_ALL
import ua.skarlet.gis.db.constants.Table.CHARACTERS

@Dao
interface CharacterDao : BaseDao<Character> {
    @Query("$SELECT_ALL $CHARACTERS")
    override fun getAll(): LiveData<List<Character>>

    @Query("$SELECT_ALL $CHARACTERS $BY_ID")
    override fun getById(itemId: Int) : LiveData<Character>
}
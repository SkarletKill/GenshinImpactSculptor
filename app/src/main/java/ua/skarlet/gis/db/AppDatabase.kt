/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ua.skarlet.gis.db.character.Character
import ua.skarlet.gis.db.character.CharacterDao
import ua.skarlet.gis.db.constants.DB_NAME

@Database(entities = [Character::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        fun getDB(appContext: Context) = Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, DB_NAME
        ).build()
    }
}
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
    @Volatile
    private var INSTANCE: AppDatabase? = null

    @Synchronized
    fun getDB(context: Context): AppDatabase {
        // if the INSTANCE is not null, then return it, otherwise create the database
        return INSTANCE ?: run {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).build()
            INSTANCE = instance
            // return instance
            instance
        }
    }

}
}
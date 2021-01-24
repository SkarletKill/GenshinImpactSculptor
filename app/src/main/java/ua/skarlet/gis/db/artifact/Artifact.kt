/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.artifact

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ua.skarlet.gis.db.constants.ID
import ua.skarlet.gis.db.constants.NAME
import ua.skarlet.gis.db.constants.Table.ARTIFACTS

@Entity(tableName = ARTIFACTS)
data class Artifact(
    @ColumnInfo(name = NAME) val name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var uid: Int = 0
}
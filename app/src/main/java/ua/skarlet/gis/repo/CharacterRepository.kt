/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.repo

import kotlinx.coroutines.CoroutineScope
import ua.skarlet.gis.db.character.Character
import ua.skarlet.gis.db.character.CharacterDao

class CharacterRepository(
    scope: CoroutineScope,
    dao: CharacterDao
) : BaseRepository<Character>(scope, dao)
/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.repo

import kotlinx.coroutines.CoroutineScope
import ua.skarlet.gis.db.build.Build
import ua.skarlet.gis.db.build.BuildDao

class BuildRepository(
    scope: CoroutineScope,
    dao: BuildDao
) : BaseRepository<Build>(scope, dao)
/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.repo

import kotlinx.coroutines.CoroutineScope
import ua.skarlet.gis.db.artifact.Artifact
import ua.skarlet.gis.db.artifact.ArtifactDao

class ArtifactRepository(
    scope: CoroutineScope,
    dao: ArtifactDao
) : BaseRepository<Artifact>(scope, dao)
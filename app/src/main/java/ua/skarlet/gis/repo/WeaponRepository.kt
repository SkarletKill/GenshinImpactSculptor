/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.repo

import kotlinx.coroutines.CoroutineScope
import ua.skarlet.gis.db.weapon.Weapon
import ua.skarlet.gis.db.weapon.WeaponDao

class WeaponRepository(
    scope: CoroutineScope,
    dao: WeaponDao
) : BaseRepository<Weapon>(scope, dao)
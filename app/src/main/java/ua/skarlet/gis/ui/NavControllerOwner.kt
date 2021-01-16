/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui

import androidx.navigation.NavController

/**
 * A NavControllerOwner is responsible for creating a [NavController], this is likely an Activity or
 * Fragment.
 */
interface NavControllerOwner {

    /**
     * The [NavController] which is being created by the NavControllerOwner.
     */
    val navController: NavController?
}
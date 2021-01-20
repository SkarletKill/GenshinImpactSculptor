/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis

import android.app.Application

class GenshinImpactApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        @SuppressWarnings("LateinitUsage")
        lateinit var application: GenshinImpactApplication
            private set
    }
}
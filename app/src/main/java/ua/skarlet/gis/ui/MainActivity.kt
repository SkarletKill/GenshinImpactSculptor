/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.skarlet.gis.R
import ua.skarlet.gis.util.logger.Log

class MainActivity : AppCompatActivity(), NavControllerOwner {

    private val log = Log(this)

    override val navController: NavController?
        get() = try {
            Navigation.findNavController(this, R.id.fragment_container)
        } catch (e: IllegalStateException) {
            log.w("Cannot find nav controller")
            null
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
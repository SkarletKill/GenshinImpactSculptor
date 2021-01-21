/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.view_s_toolbar.*
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
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(skarletToolbar)
        skarletToolbar.initUpIndicator()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                navController?.navigateUp()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
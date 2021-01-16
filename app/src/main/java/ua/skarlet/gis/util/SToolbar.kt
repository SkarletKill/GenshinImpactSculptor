/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.ober.drawerxarrowdrawable.DrawerXArrowDrawable
import kotlinx.android.synthetic.main.view_s_toolbar.view.*
import ua.skarlet.gis.util.SToolbar.ToolbarMode

typealias DrawerMode = DrawerXArrowDrawable.Mode

/**
 * Styled Toolbar. Provides the ability to choose either [ToolbarMode.BRANDED] or
 * [ToolbarMode.REGULAR] for show logo on the toolbar. [DrawerXArrowDrawable] provides
 * nice animation between X's and arrows <-
 */
class SToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : MaterialToolbar(context, attrs, defStyle) {

    private val drawerXArrowDrawable = DrawerXArrowDrawable(context, DrawerMode.DRAWER).apply {
        color = Color.BLACK
    }

    /**
     * The mode of the Toolbar ([ToolbarMode.BRANDED] or [ToolbarMode.REGULAR])
     */
    private var mode: ToolbarMode = ToolbarMode.BRANDED
        set(value) {
            field = value
            brandedToolbarLogo.visibility = when (field) {
                ToolbarMode.BRANDED -> View.VISIBLE
                ToolbarMode.REGULAR -> View.GONE
            }
        }

    private var isUpIndicatorShowing = false
        set(value) {
            field = value
            setDisplayHomeAsUpEnabled(field)
        }

    /**
     * Sets the up indicator's icon (found on the left side of the Toolbar).
     */
    fun initUpIndicator() {
        (context as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(drawerXArrowDrawable)
    }

    fun setup(mode: ToolbarMode, title: String = "", indicator: DrawerMode? = null) {
        val animationDuration =
            if (visibility == View.GONE || this.mode != mode || !isUpIndicatorShowing) {
                0
            } else {
                drawerXArrowDrawable.defaultDuration
            }
        this.mode = mode
        setTitle(title)
        setUpIndicator(indicator, animationDuration)
        visibility = View.VISIBLE
    }

    /**
     * Updates the title of the Toolbar.
     */
    private fun setTitle(title: String) {
        (context as AppCompatActivity).supportActionBar?.title = title
    }

    /**
     * Updates the up indicator's icon (found on the left side of the Toolbar).
     */
    private fun setUpIndicator(indicator: DrawerMode?, animationDuration: Long) {
        indicator?.let { drawerMode ->
            drawerXArrowDrawable.setMode(drawerMode, animationDuration)
            isUpIndicatorShowing = true
        } ?: run {
            isUpIndicatorShowing = false
        }
    }

    /**
     * Calls [androidx.appcompat.app.ActionBar.setDisplayHomeAsUpEnabled] on the Toolbar
     */
    private fun setDisplayHomeAsUpEnabled(enabled: Boolean) {
        (context as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(enabled)
    }

    enum class ToolbarMode {
        BRANDED,
        REGULAR
    }
}
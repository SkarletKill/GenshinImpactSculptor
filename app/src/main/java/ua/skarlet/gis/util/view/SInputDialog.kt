/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.view

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager.LayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.view_s_input_dialog.*
import ua.skarlet.gis.util.recycler.ReactiveAdapter

/**
 * Dialog with RecyclerView for selecting spinner items
 */
class SInputDialog(
        context: Context,
        private val headerText: String,
        val adapter: ReactiveAdapter<out RecyclerView.ViewHolder>
) : Dialog(context, R.style.FullscreenDialog) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_s_input_dialog)
        setCanceledOnTouchOutside(true)

        sInputHeader.text = headerText

        // make dialog height as a percentage (PERCENT_HEIGHT) of screen height
        val height = Resources.getSystem().displayMetrics.heightPixels
        window?.setLayout(LayoutParams.MATCH_PARENT, (height * PERCENT_HEIGHT).toInt())
        window?.setGravity(Gravity.BOTTOM)

        sInputRecyclerView.adapter = adapter
        adapter.selectedPosition?.let(sInputRecyclerView::scrollToPosition)
    }

    companion object {
        // percentage of height
        const val PERCENT_HEIGHT = 0.7f
    }
}
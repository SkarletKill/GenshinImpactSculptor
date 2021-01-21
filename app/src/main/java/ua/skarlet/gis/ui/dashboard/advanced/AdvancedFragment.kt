/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.advanced

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.skarlet.gis.R
import ua.skarlet.gis.ui.BaseFragment
import ua.skarlet.gis.util.DrawerMode
import ua.skarlet.gis.util.SToolbar.ToolbarMode

class AdvancedFragment : BaseFragment() {

    private lateinit var viewModel: AdvancedViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AdvancedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_advanced, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onResume() {
        super.onResume()
        sToolbar?.setup(ToolbarMode.REGULAR, getString(R.string.advanced), DrawerMode.ARROW)
    }
}
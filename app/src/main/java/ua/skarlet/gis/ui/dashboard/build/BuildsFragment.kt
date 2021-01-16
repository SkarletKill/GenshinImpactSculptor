/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.build

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.skarlet.gis.R

class BuildsFragment : Fragment() {

    private lateinit var buildsViewModel: BuildsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        buildsViewModel =
            ViewModelProvider(this).get(BuildsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_builds, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        buildsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}
/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.weapon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.skarlet.gis.R

class WeaponsFragment : Fragment() {

    private lateinit var weaponsViewModel: WeaponsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        weaponsViewModel =
                ViewModelProvider(this).get(WeaponsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_weapons, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        weaponsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}
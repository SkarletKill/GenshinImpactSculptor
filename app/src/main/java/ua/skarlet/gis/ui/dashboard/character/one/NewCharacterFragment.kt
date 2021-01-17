/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.skarlet.gis.R
import com.skarlet.gis.databinding.FragmentNewCharacterBinding
import kotlinx.android.synthetic.main.fragment_new_character.*
import ua.skarlet.gis.ui.BaseFragment

class NewCharacterFragment : BaseFragment() {

    private val viewModel: NewCharacterViewModel by lazy {
        ViewModelProvider(this).get(NewCharacterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentNewCharacterBinding = setAndBindContentView(inflater, container, R.layout.fragment_new_character)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.elementType.observe(viewLifecycleOwner) {
            (elementalDamageBonus.parent.parent as TextInputLayout).hint = "$it ${getString(R.string.damage_bonus)}"
        }
    }
}
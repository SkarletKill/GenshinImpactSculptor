/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character.one

import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.skarlet.gis.R
import com.skarlet.gis.databinding.FragmentNewCharacterBinding
import kotlinx.android.synthetic.main.fragment_new_character.*
import kotlinx.coroutines.runBlocking
import ua.skarlet.gis.data.enumeration.Vision
import ua.skarlet.gis.ui.BaseFragment
import ua.skarlet.gis.util.DrawerMode
import ua.skarlet.gis.util.SToolbar.ToolbarMode

class NewCharacterFragment : BaseFragment() {

    private val viewModel: NewCharacterViewModel by lazy {
        ViewModelProvider(this).get(NewCharacterViewModel::class.java)
    }

    private val elementsAdapter = VisionAdapter { position ->
        viewModel.vision.value = Vision.values()[position]
    }.apply {
        items = Vision.values().toList()
        selectedPosition = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentNewCharacterBinding = setAndBindContentView(
            inflater,
            container,
            R.layout.fragment_new_character
        )
        binding.viewModel = viewModel
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        visionDropdown.adapter = elementsAdapter
        buttonSaveCharacter.setOnClickListener { onSaveClick() }
    }

    override fun onResume() {
        super.onResume()
        sToolbar?.setup(ToolbarMode.REGULAR, getString(R.string.new_character), DrawerMode.ARROW)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu_new_item, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
        R.id.action_save -> {
            onSaveClick()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setupObservers() {
        viewModel.vision.observe(viewLifecycleOwner) { vision ->
            (elementalDamageBonus.parent.parent as TextInputLayout).hint = getString(
                R.string.e_damage_bonus,
                getString(vision.stringRes)
            )
            elementsAdapter.selectedPosition = Vision.values().indexOf(vision)
        }
    }

    private fun onSaveClick() {
        runBlocking {
            viewModel.saveItem()
        }
        navController?.navigateUp()
    }
}
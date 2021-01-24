/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.weapon.one

import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModelProvider
import com.skarlet.gis.R
import com.skarlet.gis.databinding.FragmentNewWeaponBinding
import kotlinx.android.synthetic.main.fragment_new_weapon.*
import ua.skarlet.gis.data.adapter.WeaponTypeAdapter
import ua.skarlet.gis.data.enumeration.WeaponType
import ua.skarlet.gis.ui.BaseFragment
import ua.skarlet.gis.util.DrawerMode
import ua.skarlet.gis.util.SToolbar.ToolbarMode

class NewWeaponFragment : BaseFragment() {

    private val viewModel: NewWeaponViewModel by lazy {
        ViewModelProvider(this).get(NewWeaponViewModel::class.java)
    }

    private val weaponTypeAdapter = WeaponTypeAdapter { position ->
        viewModel.weaponType.value = WeaponType.values()[position]
    }.apply {
        items = WeaponType.values().toList()
        selectedPosition = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentNewWeaponBinding = setAndBindContentView(
            inflater,
            container,
            R.layout.fragment_new_weapon
        )
        binding.viewModel = viewModel
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        weaponTypeDropdown.adapter = weaponTypeAdapter
        buttonSaveWeapon.setOnClickListener { onSaveClick() }
    }

    override fun onResume() {
        super.onResume()
        sToolbar?.setup(ToolbarMode.REGULAR, getString(R.string.new_weapon), DrawerMode.ARROW)
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
        viewModel.weaponType.observe(viewLifecycleOwner) { weaponType ->
            weaponTypeAdapter.selectedPosition = WeaponType.values().indexOf(weaponType)
        }
    }

    private fun onSaveClick() {
        viewModel.saveItem()
        navController?.navigateUp()
    }
}
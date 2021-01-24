/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.weapon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.fragment_weapons.*
import ua.skarlet.gis.ui.BaseFragment
import ua.skarlet.gis.ui.dashboard.DashboardFragmentDirections
import ua.skarlet.gis.util.DrawerMode
import ua.skarlet.gis.util.SToolbar.ToolbarMode
import ua.skarlet.gis.util.SwipeToDeleteCallback

class WeaponsFragment : BaseFragment() {

    private val viewModel: WeaponsViewModel by lazy {
        ViewModelProvider(this).get(WeaponsViewModel::class.java)
    }

    private val adapter = WeaponsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_weapons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weapons.adapter = adapter

        val swipeHandler = object : SwipeToDeleteCallback(weapons.context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.removeItem(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(weapons)

        setupObservers()
        fabAddWeapon.setOnClickListener(::onAddItemClick)
    }

    override fun onResume() {
        super.onResume()
        sToolbar?.setup(ToolbarMode.REGULAR, getString(R.string.weapons), DrawerMode.ARROW)
    }

    private fun setupObservers() {
        viewModel.weapons.observe(viewLifecycleOwner) {
            adapter.items = it
        }
    }

    private fun onAddItemClick(view: View) {
        navController?.navigate(DashboardFragmentDirections.onNewWeaponClick())
    }
}
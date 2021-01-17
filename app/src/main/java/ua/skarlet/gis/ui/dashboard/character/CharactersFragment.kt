/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.fragment_character.*
import ua.skarlet.gis.ui.BaseFragment
import ua.skarlet.gis.ui.dashboard.DashboardFragmentDirections
import ua.skarlet.gis.util.SwipeToDeleteCallback

class CharactersFragment : BaseFragment() {

    private val viewModel: CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    private val adapter = CharactersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_character, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characters.adapter = adapter

        val swipeHandler = object : SwipeToDeleteCallback(characters.context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.removeItem(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(characters)

        setupObservers()
        fabAddCharacter.setOnClickListener(::onAddItemClick)
    }

    private fun setupObservers() {
        viewModel.characters.observe(viewLifecycleOwner) {
            adapter.items = it
        }
    }

    private fun onAddItemClick(view: View) {
        navController?.navigate(DashboardFragmentDirections.onNewCharacterClick())
    }
}
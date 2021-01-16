/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.skarlet.gis.R
import com.skarlet.gis.databinding.FragmentWelcomeBinding
import ua.skarlet.gis.ui.BaseFragment
import ua.skarlet.gis.util.DrawerMode
import ua.skarlet.gis.util.SToolbar.ToolbarMode

class WelcomeFragment : BaseFragment() {

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentWelcomeBinding = setAndBindContentView(inflater, container, R.layout.fragment_welcome)
//        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonGoPrimary)
        button.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.fragment_container)
                .navigate(WelcomeFragmentDirections.onPrimaryContentClick())
        }
    }

    override fun onResume() {
        super.onResume()
        sToolbar?.setup(ToolbarMode.REGULAR, getString(R.string.welcome), DrawerMode.ARROW)
    }
}
/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import ua.skarlet.gis.ui.BaseFragment

class DashboardFragment : BaseFragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = setContentView(inflater, container, R.layout.fragment_dashboard)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
    }

    @SuppressLint("WrongConstant")
    private fun setupViewPager() {
        viewPager.offscreenPageLimit = DashboardFragmentPagerAdapter.NUMBER_OF_TABS
        viewPager.adapter = DashboardFragmentPagerAdapter(this)
        viewPager.isUserInputEnabled = false
        viewPager.setPageTransformer(null)
        bottomNavView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val position = DashboardFragmentPagerAdapter.getPositionForMenuId(item.itemId)
        viewPager.setCurrentItem(position, false)
        return true
    }
}
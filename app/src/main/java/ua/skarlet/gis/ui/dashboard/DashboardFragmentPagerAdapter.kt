/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.skarlet.gis.R
import ua.skarlet.gis.ui.dashboard.advanced.AdvancedFragment
import ua.skarlet.gis.ui.dashboard.artifact.ArtifactsFragment
import ua.skarlet.gis.ui.dashboard.build.BuildsFragment
import ua.skarlet.gis.ui.dashboard.character.CharactersFragment
import ua.skarlet.gis.ui.dashboard.weapon.WeaponsFragment

class DashboardFragmentPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = NUMBER_OF_TABS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            Tab.CHARACTERS.position -> CharactersFragment()
            Tab.WEAPONS.position -> WeaponsFragment()
            Tab.BUILDS.position -> BuildsFragment()
            Tab.ARTIFACTS.position -> ArtifactsFragment()
            Tab.ADVANCED.position -> AdvancedFragment()
            else -> throw IllegalStateException("Bad position")
        }
    }

    enum class Tab(
        @IdRes val menuItemId: Int,
        val position: Int
    ) {
        CHARACTERS(R.id.menu_characters, 0),
        WEAPONS(R.id.menu_weapons, 1),
        BUILDS(R.id.menu_builds, 2),
        ARTIFACTS(R.id.menu_artifacts, 3),
        ADVANCED(R.id.menu_advanced, 4)
    }

    companion object {
        const val NUMBER_OF_TABS = 5

        fun getPositionForMenuId(@IdRes menuItemId: Int): Int {
            Tab.values().forEach {
                if (menuItemId == it.menuItemId) {
                    return it.position
                }
            }
            return 0
        }

        fun getTabForPosition(position: Int): Tab? {
            Tab.values().forEach {
                if (position == it.position) {
                    return it
                }
            }
            return null
        }
    }
}
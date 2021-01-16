/*
 * Copyright (c) 2021 by Skarlet RED
 */
package ua.skarlet.gis.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.skarlet.gis.R
import ua.skarlet.gis.util.SToolbar

abstract class BaseFragment: Fragment(), NavControllerOwner {

    protected var binding: ViewDataBinding? = null
    protected var isAlreadyBound = false

    protected val mainActivity: MainActivity?
        get() = activity as? MainActivity

    protected val sToolbar: SToolbar?
        get() = mainActivity?.findViewById(R.id.skarletToolbar)

    override val navController: NavController?
        get() = (activity as NavControllerOwner).navController

    @Suppress("UNCHECKED_CAST")
    protected fun <ViewBindingType : ViewDataBinding?> setAndBindContentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        @LayoutRes layoutResId: Int
    ): ViewBindingType {
        binding?.let {
            isAlreadyBound = true
            binding?.lifecycleOwner = viewLifecycleOwner
            return it as ViewBindingType
        }
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding?.lifecycleOwner = viewLifecycleOwner
        return binding as ViewBindingType
    }

    protected fun setContentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        @LayoutRes layoutResID: Int
    ): View = inflater.inflate(layoutResID, container, false)

    /**
     * @return true if this fragment needs to intercept [onBackPressed] from a child fragment.
     */
    open fun onInterceptBackPressed(): Boolean = false

    /**
     * Override if the fragment needs to react to a back button press in a special way.
     * @return true if the back button press is consumed.
     */
    open fun onBackPressed(): Boolean = false
}
package com.userstory.presentation.utils

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.userstory.presentation.R


/**
 * Refer to nav_graph NavController
 */
fun Fragment.findTopNavController(): NavController {
    val topLevelHost =
        requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
    return topLevelHost.navController
}
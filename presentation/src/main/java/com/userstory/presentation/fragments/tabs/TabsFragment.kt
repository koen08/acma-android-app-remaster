package com.userstory.presentation.fragments.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.userstory.presentation.R
import com.userstory.presentation.databinding.FragmentTabsBinding

class TabsFragment : Fragment() {

    lateinit var binding: FragmentTabsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment: NavHostFragment =
            childFragmentManager.findFragmentById(R.id.navHostContainer) as NavHostFragment
        val bottomNav = binding.bottomNav
        bottomNav.setupWithNavController(navHostFragment.navController)
    }
}
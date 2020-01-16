package com.disruption.navigationgraphdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment_home) as NavHostFragment

        //Set up the bottom nav view
        view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navController = navHostFragment.navController)

        //TODO: Use the top level navigation
        //Set up the bottom nav view
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        //Make sure the toolbar does not show a back button
        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            toolbar.title = destination.label
        }

        return view
    }
}

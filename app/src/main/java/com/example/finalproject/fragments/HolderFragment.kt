package com.example.finalproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.finalproject.MainActivity
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentHolderBinding
import com.example.finalproject.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HolderFragment: Fragment () {

    private var _binding: FragmentHolderBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHolderBinding.inflate(inflater, container, false)
        val view = binding.root



        val host = childFragmentManager.findFragmentById(R.id.navigationMenu) as NavHostFragment
        navController = host.findNavController()



        val navView: BottomNavigationView = (binding.bottomNavigationMenu)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.workoutsFragment, R.id.profileFragment
            )
        )

        setupActionBarWithNavController(requireActivity() as AppCompatActivity, navController, appBarConfiguration)
        navView.setupWithNavController(navController)







        return view




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


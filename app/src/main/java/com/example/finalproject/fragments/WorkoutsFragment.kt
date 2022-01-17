package com.example.finalproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.finalproject.R
import com.example.finalproject.adapters.ViewPagerAdapter
import com.example.finalproject.databinding.FragmentProfileBinding
import com.example.finalproject.databinding.FragmentWorkoutsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class WorkoutsFragment: Fragment () {
    private var _binding: FragmentWorkoutsBinding? = null

    private lateinit var viewPager : ViewPager2
    private lateinit var tabLayout : TabLayout
    private lateinit var adapter : ViewPagerAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWorkoutsBinding.inflate(inflater, container, false)

        val view = binding.root



        init()


        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager) {tab,position ->
            when (position)  {

                0 -> {
                    tab.setIcon(R.drawable.svg_arm)
                    tab.text = "arms"
                }
                1 -> {
                    tab.text = "cardio"
                    tab.setIcon(R.drawable.svg_cardio)
                }
                2 -> {
                    tab.text = "legs"
                    tab.setIcon(R.drawable.svg_leg)
                }

            }

        }.attach()

        return view
    }

    fun init (){
        viewPager = binding.viewPager
        tabLayout = binding.tabLayout
        adapter = ViewPagerAdapter(this)

    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }



}



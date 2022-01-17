package com.example.finalproject.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finalproject.fragments.WorkoutsFragment
import com.example.finalproject.fragments.workouts.WorkoutOne
import com.example.finalproject.fragments.workouts.WorkoutThree
import com.example.finalproject.fragments.workouts.WorkoutTwo

class ViewPagerAdapter (fragment: WorkoutsFragment): FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WorkoutOne()
            1 -> WorkoutTwo()
            2 -> WorkoutThree()
            else -> WorkoutOne()
        }
    }


}
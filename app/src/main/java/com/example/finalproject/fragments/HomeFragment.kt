package com.example.finalproject.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserInfo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment () {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val database = Firebase.database


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root




        registerListeners()






        return view

    }
    fun registerListeners () {
        binding.gotoButton.setOnClickListener{

            findNavController().navigate(R.id.action_homeFragment_to_workoutsFragment)

        }



//        if (registered == 1) {
//
//        }
//        else {
//            Toast.makeText(requireContext(), "Bijo bijoo", Toast.LENGTH_SHORT).show()
//        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
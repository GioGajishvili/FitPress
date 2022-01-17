package com.example.finalproject.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.classes.UserInfo
import com.example.finalproject.databinding.FragmentLoginBinding
import com.example.finalproject.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProfileFragment: Fragment () {


    private val binding get() = _binding!!

    private var _binding: FragmentProfileBinding? = null


    private var auth = FirebaseAuth.getInstance()
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val view = binding.root


        readData()


        binding.buttonLogout.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_mainActivity)
        }


        return view
    }

    private fun readData () {
        database = FirebaseDatabase.getInstance().getReference("userInfo")
        database.child(auth.currentUser?.uid!!).get().addOnSuccessListener {
            if (it.exists()) {
                val height = it.child("height").value
                val surName = it.child("surname").value
                val name = it.child("name").value
                val weight = it.child("weight").value
                val age = it.child("age").value
                binding.editTextHeight.setText("Your Height - $height Cm")
                binding.editTextWeight.setText("Your Weight - $weight kg")
                binding.editTextName.text = name.toString()
                binding.editTextSurname.text = surName.toString()
                binding.editTextAge.setText("Your age - $age")
                binding.editTextEmail2.setText(auth.currentUser?.email!!)
            }
            else {
                Toast.makeText(requireContext(), "User Does not Exists!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }

}
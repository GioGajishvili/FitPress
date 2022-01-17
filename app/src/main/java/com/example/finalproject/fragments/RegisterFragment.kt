package com.example.finalproject.fragments

import android.app.DirectAction
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentLoginBinding
import com.example.finalproject.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterFragment: Fragment() {

    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!
    private var auth = FirebaseAuth.getInstance()
    private lateinit var mDbRef : DatabaseReference
    private lateinit var user: com.example.finalproject.classes.UserInfo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        val view = binding.root

        registerListeners()

        return view
    }
    private fun registerListeners() {

        binding.buttonRegister2.setOnClickListener {

            if (Information()) {

                val email = binding.editTextEmail2.text.toString()
                val password = binding.editTextPassword.text.toString()


                user = com.example.finalproject.classes.UserInfo(
                    binding.editName.text.toString(),
                    binding.editSurname.text.toString(),
                    binding.editTextHeight.text.toString(),
                    binding.editTextWeight.text.toString(),
                    binding.editTextAge.text.toString()
                )

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            Toast.makeText(requireContext(),"You have registered successfully", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

                            mDbRef = FirebaseDatabase.getInstance().getReference("userInfo")
                            mDbRef.child(auth.currentUser?.uid!!).child("name").setValue(user.name)
                            mDbRef.child(auth.currentUser?.uid!!).child("surname").setValue(user.surname)
                            mDbRef.child(auth.currentUser?.uid!!).child("height").setValue(user.height)
                            mDbRef.child(auth.currentUser?.uid!!).child("weight").setValue(user.weight)
                            mDbRef.child(auth.currentUser?.uid!!).child("age").setValue(user.age)

                        } else {

                            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()

                        }
                    }



            }
        }
    }
    fun Information(): Boolean {

        if (binding.editTextEmail2.text.toString().equals("")) {
            Toast.makeText(context, "please enter e-mail", Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.editTextPassword.text.toString().equals("")) {
            Toast.makeText(context, "please enter password", Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.editTextRepeatPassword.text.toString().equals("")) {
            Toast.makeText(context, "please repeat password", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!binding.editTextPassword.text.toString().equals(binding.editTextRepeatPassword.text.toString())) {
            Toast.makeText(context, "password does not match", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}
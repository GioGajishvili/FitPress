package com.example.finalproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentProfileBinding
import com.example.finalproject.databinding.FragmentResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordFragment: Fragment() {


    private var _binding: FragmentResetPasswordBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)

        val view = binding.root



        registerListeners()


        return view
    }

    private fun registerListeners() {
        binding.buttonResetPassword2.setOnClickListener(){
            var email = binding.editTextEmail.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(requireContext(), "Email is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { email ->
                    if (email.isSuccessful){
                        Toast.makeText(requireContext(), "Check your E-mail", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(requireContext(), "another gay error", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }

}

package com.example.akbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.akbank.databinding.FragmentFirstBinding
import com.example.akbank.databinding.FragmentSecondBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class secondFragment : Fragment() {

    private var _binding: FragmentSecondBinding?=null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private val TAG = "MainActivity"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        auth = Firebase.auth
        binding.imageButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.button3.setOnClickListener {
            val email=binding.emailText.text.toString()
            val password=binding.parolaText.text.toString()
            register(email,password)
        }
        return binding.root
    }

    fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                //Navigate to main page
                Toast.makeText(requireContext(), "Kayıt başarılı", Toast.LENGTH_SHORT).show()
            } else if (result.isCanceled) {
                //Show toast message
                Toast.makeText(requireContext(), "Kayıt başarısız", Toast.LENGTH_SHORT).show()
            }
        }
    }





}


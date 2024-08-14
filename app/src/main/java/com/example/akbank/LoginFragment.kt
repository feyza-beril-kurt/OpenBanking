package com.example.akbank

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.akbank.databinding.LoginFragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private val TAG = "MainActivity"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        auth = Firebase.auth

        binding.button6.setOnClickListener {
            val email=binding.emailText.text.toString()
            val password=binding.parolaText.text.toString()
            login(email,password)

        }
        binding.imageButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.button3.setOnClickListener {
            val email = binding.emailText.text.toString()
            val password = binding.parolaText.text.toString()
            register(email, password)
        }


        return binding.root
    }

    fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                Toast.makeText(requireContext(), "Kayıt başarılı", Toast.LENGTH_SHORT).show()
            } else if (result.isCanceled) {
                Toast.makeText(requireContext(), "Kayıt başarısız", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                Log.d(TAG, "signInWithEmail:Giriş işlemi başarılı")
                findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            } else if (result.isCanceled) {
                Log.w(TAG, "signInWithEmail:failure", result.exception)
                Toast.makeText(
                    requireContext(), "Giriş işlemi başarısız.", Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }
}





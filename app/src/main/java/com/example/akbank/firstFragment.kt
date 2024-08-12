package com.example.akbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.akbank.databinding.FragmentFirstBinding
import com.google.firebase.auth.FirebaseAuth

class firstFragment : Fragment() {


    private var _binding:FragmentFirstBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding=FragmentFirstBinding.inflate(inflater,container,false)

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}

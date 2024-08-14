package com.example.akbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.akbank.databinding.HostFragmentBinding
import com.example.akbank.databinding.StartFragmentBinding


class HostFragment : Fragment() {
    private var _binding: HostFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HostFragmentBinding.inflate(inflater, container, false)
        replaceFragment(HomeFragment())

        binding.bottomnavigationview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                }

                R.id.search -> {
                    replaceFragment(SearchFragment())
                }

                R.id.favorites -> {
                    replaceFragment(favorites_Fragment())
                }

                R.id.otherBanks -> {
                    replaceFragment(OtherBanksFragment())
                }

                else -> {
                    replaceFragment(HomeFragment())
                }
            }
            true
        }

        return binding.root

    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}

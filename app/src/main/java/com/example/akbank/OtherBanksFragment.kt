package com.example.akbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.akbank.databinding.HostFragmentBinding
import com.example.akbank.databinding.OtherBanksFragmentBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

class OtherBanksFragment : Fragment(), NewBankClickListener {

    private var _binding: OtherBanksFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var bankList: BankList



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = OtherBanksFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.setHasFixedSize(true)

        bankList = BankList()




        binding.fab.setOnClickListener {
            val action  = HostFragmentDirections.actionThirdFragmentToNewBankFragment(bankList)
            findNavController().navigate(action)
        }

        getBanks()
    }

    private fun getBanks() {
        binding.progressBar.isVisible=true
        val uid = Firebase.auth.currentUser?.uid
        Firebase.firestore.collection("Accounts").document(uid!!).get().addOnSuccessListener {
            val banks = it.toObject<BankList>()
            binding.progressBar.isVisible=false
            banks?.let {
                bankList = banks
                binding.emptyTextView.isVisible=bankList.bankList.isEmpty()
                binding.recyclerView.adapter=NewBankAdapter(banks.bankList, this)
            } ?: kotlin.run {
                binding.emptyTextView.isVisible=true
            }
        }


    }

    override fun onBankClick(banks: Banks) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Açık Bankacılık")
            .setMessage("Bu bankayı kaldırmak istiyor musunuz?")
            .setNegativeButton("Hayır") { dialog, which ->
                // Respond to negative button press
            }
            .setPositiveButton("Evet") { dialog, which ->
                val uid = Firebase.auth.currentUser?.uid
                val bank = bankList.bankList.toMutableList()

                if (uid != null) {

                    bank.remove(banks)
                    Firebase.firestore.collection("Accounts").document(uid)
                        .set(BankList(bank))
                        .addOnSuccessListener {
                            getBanks()
                            Toast.makeText(requireContext(), "Başarıyla Silindi.", Toast.LENGTH_LONG).show()
                        }
                }
            }
            .show()
    }
}
package com.example.akbank

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.akbank.databinding.FragmentNewBankBinding
import com.example.akbank.databinding.OtherBanksFragmentBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NewBankFragment : Fragment(), NewBankClickListener {

    private var _binding: FragmentNewBankBinding? = null
    private val binding get() = _binding!!

    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db.collection("Banks").get().addOnSuccessListener { result->
            val bankList = arrayListOf<Banks>()

            for (document in result) {
                val banks = Banks(
                    (document.data.get("id") as Long).toInt(),
                    document.data.get("imageUrl") as String,
                    document.data.get("title") as String
                )
                bankList.add(banks)
            }

            binding.recyclerView.adapter=NewBankAdapter(bankList, this)
        }.addOnFailureListener { exception ->
            Toast.makeText(requireContext(),exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewBankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.setHasFixedSize(true)

        binding.imageView5.setOnClickListener{
            findNavController().popBackStack()
        }
    }

    data class BankList(
        val bankList: List<Banks>
    )

    override fun onBankClick(banks: Banks) {
        val uid = Firebase.auth.currentUser?.uid
        if (uid != null) {

            db.collection("Accounts").document(uid)
                .set(BankList(listOf(banks)))
                .addOnSuccessListener {
                    println("Veri başarıyla Firestore'a kaydedildi")
                }
        } else {
            println("Kullanıcı giriş yapmadı")
        }
    }

}

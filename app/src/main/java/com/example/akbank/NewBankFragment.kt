package com.example.akbank

import android.os.Bundle
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

class NewBankFragment : Fragment() {

    private var _binding: FragmentNewBankBinding? = null
    private val binding get() = _binding!!

    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageId = arrayOf(
            R.drawable.img_6,
            R.drawable.img_5,
            R.drawable.img_7,
            R.drawable.denizbank,
            R.drawable.img_8
        )
        heading = arrayOf(
            "QNB Finansbank",
            "TEB Türkiye Finans Bankası",
            "Türkiye İş Bankası",
            "Denizbank",
            "Pokus"
        )
    }

    private fun getUserData() {
        newArrayList= arrayListOf<News>()
        for (i in imageId.indices){
            val news=News(imageId[i],heading[i])
            newArrayList.add(news)
        }
        binding.recyclerView.adapter=MyAdapter(newArrayList)
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

        getUserData()
    }
}

package com.example.akbank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.akbank.databinding.HostFragmentBinding
import com.example.akbank.databinding.OtherBanksFragmentBinding

class OtherBanksFragment : Fragment() {

    private var _binding: OtherBanksFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            imageId= arrayOf(
                R.drawable.img,
                R.drawable.img_1,
                R.drawable.img_9
            )
            heading= arrayOf(
                "Ziraat Bankası",
                "Garanti BBVA",
                "Yapı Kredi Bankası"
            )
    }

    private fun getUserData() {
        for (i in imageId.indices){
            val news=News(imageId[i],heading[i])
            newArrayList.add(news)
        }
        binding.recyclerView.adapter=MyAdapter(newArrayList)
    }

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

        newArrayList= arrayListOf<News>()
        getUserData()

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_newBankFragment)
        }
    }
}
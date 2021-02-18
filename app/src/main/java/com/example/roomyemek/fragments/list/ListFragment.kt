package com.example.roomyemek.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomyemek.R
import com.example.roomyemek.data.YemekViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var mYemekViewModel: YemekViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val adapter = ListAdapter()
        val recyclerView = view.rv

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mYemekViewModel = ViewModelProvider(this).get(YemekViewModel::class.java)
        mYemekViewModel.readAllData.observe(viewLifecycleOwner, Observer{ yemek ->
            adapter.setData(yemek)
        })

        view.fab.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }
}
package com.example.roomyemek.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomyemek.R
import com.example.roomyemek.data.Yemek
import com.example.roomyemek.data.YemekViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class addFragment : Fragment() {

    private lateinit var mYemekViewModel: YemekViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mYemekViewModel = ViewModelProvider(this).get(YemekViewModel::class.java)

        view.buttonEkle.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase(){
        val yemek_adi = editTextYemekAd.text.toString()
        val yemek_fiyat = editTextYemekFiyat.text
        val yemek_adet = editTextYemekAdet.text

        if(inputCheck(yemek_adi, yemek_fiyat, yemek_adet)){
            val yemek = Yemek(0, yemek_adi, "dd", Integer.parseInt(yemek_fiyat.toString()), Integer.parseInt(yemek_adet.toString()))

            mYemekViewModel.YemekEkle(yemek)
            Toast.makeText(requireContext(), "eklendi", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }

    private fun inputCheck(yemek_adi:String, yemek_fiyat:Editable, yemek_adet:Editable): Boolean{
        return !(TextUtils.isEmpty(yemek_adi) && yemek_fiyat.isEmpty() && yemek_adet.isEmpty())
    }



}
package com.example.roomyemek.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomyemek.R
import com.example.roomyemek.data.Yemek
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var yemekList = emptyList<Yemek>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return yemekList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = yemekList[position]
        holder.itemView.YemekAd.text = currentItem.yemek_adi
        holder.itemView.yemekFiyat.text = "${currentItem.yemek_fiyat.toString()}TL"
        holder.itemView.YemekAdet.text = "${currentItem.yemek_siparis_adet.toString()} adet"
    }

    fun setData(yemek: List<Yemek>){
        this.yemekList = yemek
        notifyDataSetChanged()
    }
}
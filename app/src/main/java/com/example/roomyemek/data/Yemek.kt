package com.example.roomyemek.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "yemekler")
data class Yemek (
    @PrimaryKey(autoGenerate = true)
    val yemek_id:Int,
    val yemek_adi:String,
    val yemek_resim_adi:String,
    val yemek_fiyat:Int,
    val yemek_siparis_adet:Int){
}
package com.example.roomyemek.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class YemekRepository(private  val yemekdao: YemekDao) {

    val readAllData: LiveData<List<Yemek>> = yemekdao.readAllData()

    suspend fun YemekEkle(yemek: Yemek){
        yemekdao.YemekEkle(yemek)
    }

    fun searchDatabase(searchQuery :String): Flow<List<Yemek>>{
        return yemekdao.searchDatabase(searchQuery)
    }
}
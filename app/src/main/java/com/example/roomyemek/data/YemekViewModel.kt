package com.example.roomyemek.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YemekViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Yemek>>
    private val repository: YemekRepository

    init{
        val yemekdao = YemekDatabase.getDatabase(application).yemekdao()
        repository = YemekRepository(yemekdao)
        readAllData = repository.readAllData
    }

    fun YemekEkle(yemek: Yemek){
        viewModelScope.launch(Dispatchers.IO) {
            repository.YemekEkle(yemek)
        }
    }

}

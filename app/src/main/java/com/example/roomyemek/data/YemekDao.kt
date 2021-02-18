package com.example.roomyemek.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface YemekDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  YemekEkle( yemek: Yemek)

    @Query("SELECT * FROM yemekler ORDER BY yemek_id ASC")
    fun readAllData(): LiveData<List<Yemek>>

    @Query("SELECT * FROM yemekler WHERE yemek_adi LIKE:searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Yemek>>
}
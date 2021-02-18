package com.example.roomyemek.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Yemek::class], version = 1, exportSchema = false)
abstract class YemekDatabase : RoomDatabase(){

    abstract fun yemekdao(): YemekDao

    companion object{
        @Volatile
        private var INSTANCE: YemekDatabase? = null

        fun getDatabase(context: Context): YemekDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    YemekDatabase::class.java,
                    "yemek_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
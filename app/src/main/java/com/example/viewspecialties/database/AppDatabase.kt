package com.example.viewspecialties.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.viewspecialties.AppSpecialty

import com.example.viewspecialties.database.dao.CacheSpecialtyDao
import com.example.viewspecialties.database.entity.CacheEmployeeEntity

import com.example.viewspecialties.database.entity.CacheSpecialtyEntity


@Database(
    entities = [
        CacheEmployeeEntity::class,

        CacheSpecialtyEntity::class
    ],
    version = 4
)
abstract class AppDatabase : RoomDatabase() {


     abstract fun cacheEmployeeDao(): CacheEmployeeDao
     abstract fun cacheSpecialtyDao(): CacheSpecialtyDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke() = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase().also { instance = it }
        }

        private fun buildDatabase() = Room.databaseBuilder(
            AppSpecialty.getContext(),
            AppDatabase::class.java, "response"
        ).build()

      /*  fun getDatabase(contex: Context): AppDatabase{
            return instance?: synchronized(this){
                val instan =  Room.databaseBuilder(contex.applicationContext,
                AppDatabase::class.java,
                "database_response").build()

                instance = instan
                instance!!
            }
        }*/
    }
}




package com.example.viewspecialties.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.viewspecialties.modelService.Specialty

@Dao
interface CacheSpecialtyDao {
    @Query("SELECT * FROM cache_specialty")
    fun getSpecialty() : List<Specialty>
}
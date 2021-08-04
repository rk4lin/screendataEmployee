package com.example.viewspecialties.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.viewspecialties.database.entity.CacheSpecialtyEntity
import com.example.viewspecialties.modelService.Specialty

@Dao
interface CacheSpecialtyDao {
    @Query("SELECT * FROM cache_specialty")
    fun getSpecialty() : List<Specialty>

    @Insert
    fun insertSpecialty(specialties: MutableList<CacheSpecialtyEntity>)

    @Query("DELETE FROM cache_specialty")
    fun deleteAllSpecialty()
}
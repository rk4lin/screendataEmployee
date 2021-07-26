package com.example.viewspecialties.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.viewspecialties.listspecialties.model.Speciality

@Dao
interface CacheSpecialtyDao {
    @Query("SELECT * FROM cache_specialty")
    fun getSpecialty() : List<Speciality>
}
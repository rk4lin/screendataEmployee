package com.example.viewspecialties.database

import androidx.room.*
import com.example.viewspecialties.database.entity.CacheEmployeeEntity
import com.example.viewspecialties.modelService.Employee


@Dao
interface CacheEmployeeDao {
    @Query("SELECT * FROM cache_employee")
    fun getEmployees(): List<CacheEmployeeEntity>

    @Query("SELECT * FROM cache_employee where specId = :specialtyId")
    fun getById(specialtyId: Int) : List<CacheEmployeeEntity>

    @Insert
    fun insertEmployee(employee: CacheEmployeeEntity)

    @Insert
    fun insertAll(employees: List<CacheEmployeeEntity>)

}
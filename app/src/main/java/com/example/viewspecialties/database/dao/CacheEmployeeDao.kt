package com.example.viewspecialties.database

import androidx.room.*
import com.example.viewspecialties.modelService.Employee


@Dao
interface CacheEmployeeDao {
    @Query("SELECT * FROM cache_employee")
    fun getEmployees(): List<Employee>


}
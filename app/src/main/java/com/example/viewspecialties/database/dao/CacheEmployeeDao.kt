package com.example.viewspecialties.database

import androidx.room.*
import com.example.viewspecialties.presentation.listspecialties.model.Employee


@Dao
interface CacheEmployeeDao {
    @Query("SELECT * FROM cache_employee")
    fun getEmployees(): List<Employee>


}
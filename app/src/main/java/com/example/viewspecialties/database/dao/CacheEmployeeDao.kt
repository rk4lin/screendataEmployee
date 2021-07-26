package com.example.viewspecialties.database

import androidx.room.*
import com.example.viewspecialties.listspecialties.model.Employee
import com.example.viewspecialties.listspecialties.model.Speciality


@Dao
interface CacheEmployeeDao {
    @Query("SELECT * FROM cache_employee")
    fun getEmployees(): List<Employee>


}
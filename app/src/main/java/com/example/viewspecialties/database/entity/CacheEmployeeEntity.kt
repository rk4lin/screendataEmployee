package com.example.viewspecialties.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "cache_employee")
    data class CacheEmployeeEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val f_name: String?,
        val l_name: String?,
        val birthday: String?,
        val avatr_url: String?,
    )


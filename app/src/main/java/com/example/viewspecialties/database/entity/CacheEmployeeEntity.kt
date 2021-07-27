package com.example.viewspecialties.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "cache_employee",
        foreignKeys = [ForeignKey(
            entity = CacheSpecialtyEntity::class,
            parentColumns = ["key"],
            childColumns = ["specialty_key"],
            onDelete = ForeignKey.CASCADE
        )])
    data class CacheEmployeeEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val f_name: String?,
        val l_name: String?,
        val birthday: String?,
        val avatr_url: String?,
        val specialty_key: Int
    )


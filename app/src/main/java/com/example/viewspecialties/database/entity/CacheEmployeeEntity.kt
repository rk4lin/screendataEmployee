package com.example.viewspecialties.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "cache_employee",
    foreignKeys =[ ForeignKey(
        entity = CacheSpecialtyEntity::class,
        parentColumns = ["specialty_id"],
        childColumns = ["specId"],
        )]
)
data class CacheEmployeeEntity(
    @PrimaryKey
    val specialty_id: Int? = null,
    val f_name: String,
    val l_name: String,
    val birthday: String,
    val avatr_url: String? = null,
    val specId: Long
)


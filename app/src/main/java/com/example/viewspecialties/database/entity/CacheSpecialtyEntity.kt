package com.example.viewspecialties.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cache_specialty")
data class CacheSpecialtyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val specialty_id: Int,
    val name: String

)

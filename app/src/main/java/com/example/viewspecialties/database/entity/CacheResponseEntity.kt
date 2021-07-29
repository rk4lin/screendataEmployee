package com.example.viewspecialties.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.viewspecialties.modelService.ObjectResponse


@Entity(tableName = "cache_response")
data class CacheResponseEntity (
    @PrimaryKey(autoGenerate = true)
    val response_id: Int,
    val response: ObjectResponse
)
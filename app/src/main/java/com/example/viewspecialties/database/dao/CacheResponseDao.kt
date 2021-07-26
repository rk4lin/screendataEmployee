package com.example.viewspecialties.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.viewspecialties.database.entity.CacheResponseEntity
import com.example.viewspecialties.listspecialties.model.ObjectResponse
import com.example.viewspecialties.listspecialties.model.Speciality

@Dao
interface CacheResponseDao {
    @Query("SELECT * FROM cache_response")
    fun getData() : ObjectResponse

    @Insert
    fun insertResponse(responseObject: ObjectResponse)
}
package com.example.viewspecialties.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.viewspecialties.presentation.listspecialties.model.ObjectResponse

@Dao
interface CacheResponseDao {
    @Query("SELECT * FROM cache_response")
    fun getData() : ObjectResponse

    @Insert
    fun insertResponse(responseObject: ObjectResponse)
}
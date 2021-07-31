package com.example.viewspecialties.modelService

import com.google.gson.annotations.SerializedName

//это использую для парсинга в json
data class ObjectResponse(
    @SerializedName("response")
    val resp: List<Employee>
)
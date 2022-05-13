package com.lopes.crudcrudretrofit.data.api.dto

import com.squareup.moshi.Json

data class PostComicResponse (
    @field:Json(name = "_id") val id: String,
    @field:Json(name = "name") val name: String
)
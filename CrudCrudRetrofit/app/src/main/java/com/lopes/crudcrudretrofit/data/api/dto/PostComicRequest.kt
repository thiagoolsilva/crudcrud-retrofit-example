package com.lopes.crudcrudretrofit.data.api.dto

import com.squareup.moshi.Json

data class PostComicRequest (
    @field:Json(name = "name") val name: String
)
package com.lopes.crudcrudretrofit.data.api

import com.lopes.crudcrudretrofit.data.api.dto.GetComicsItemResponse
import com.lopes.crudcrudretrofit.data.api.dto.PostComicRequest
import com.lopes.crudcrudretrofit.data.api.dto.PostComicResponse
import retrofit2.http.*

interface ComicAPIContract {

    @POST("comics")
    suspend fun sendComic(
        @Body comic: PostComicRequest
    ): PostComicResponse

    @GET("comics")
    suspend fun getAllComics(): ArrayList<GetComicsItemResponse>

    @DELETE("comics/{id}")
    suspend fun deleteComicsById(
        @Path("id") path:String
    )

}
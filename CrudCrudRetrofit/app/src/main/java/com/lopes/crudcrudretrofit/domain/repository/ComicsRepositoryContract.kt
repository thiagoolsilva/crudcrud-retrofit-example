package com.lopes.crudcrudretrofit.domain.repository

import com.lopes.crudcrudretrofit.data.api.dto.GetComicsItemResponse
import com.lopes.crudcrudretrofit.data.api.dto.PostComicRequest
import com.lopes.crudcrudretrofit.data.api.dto.PostComicResponse

interface ComicsRepositoryContract {
    suspend fun getAllComics(): ArrayList<GetComicsItemResponse>
    suspend fun sendComics(comic: PostComicRequest): PostComicResponse
    suspend fun deleteComicsById(id:String)
}

interface ComicsRepositoryNetworkContract {
    suspend fun getAllComics(): ArrayList<GetComicsItemResponse>
    suspend fun sendComics(comic: PostComicRequest): PostComicResponse
    suspend fun deleteComicsById(id:String)
}
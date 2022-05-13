package com.lopes.crudcrudretrofit.data.repository

import com.lopes.crudcrudretrofit.data.api.dto.PostComicRequest
import com.lopes.crudcrudretrofit.domain.repository.ComicsRepositoryContract
import com.lopes.crudcrudretrofit.domain.repository.ComicsRepositoryNetworkContract
import javax.inject.Inject

class ComicRepositoryImpl @Inject constructor (
    private val comicsRetrofit: ComicsRepositoryNetworkContract
):  ComicsRepositoryContract  {
    override suspend fun getAllComics() = comicsRetrofit.getAllComics()
    override suspend fun sendComics(comic: PostComicRequest) = comicsRetrofit.sendComics(comic)
    override suspend fun deleteComicsById(id: String) = comicsRetrofit.deleteComicsById(id)
}
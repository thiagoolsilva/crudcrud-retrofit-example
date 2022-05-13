package com.lopes.crudcrudretrofit.data.source

import com.lopes.crudcrudretrofit.data.api.ComicAPIContract
import com.lopes.crudcrudretrofit.data.api.dto.PostComicRequest
import com.lopes.crudcrudretrofit.domain.repository.ComicsRepositoryNetworkContract
import javax.inject.Inject

class ComicsNetworkSourceImpl
@Inject constructor(
    private val retrofitSource: ComicAPIContract
): ComicsRepositoryNetworkContract {
    override suspend fun getAllComics()  = retrofitSource.getAllComics()
    override suspend fun sendComics(comic: PostComicRequest)  = retrofitSource.sendComic(comic)
    override suspend fun deleteComicsById(id: String) = retrofitSource.deleteComicsById(id)
}
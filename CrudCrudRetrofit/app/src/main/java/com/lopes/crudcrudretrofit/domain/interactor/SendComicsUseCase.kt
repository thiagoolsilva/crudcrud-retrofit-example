package com.lopes.crudcrudretrofit.domain.interactor

import com.lopes.crudcrudretrofit.data.api.dto.PostComicRequest
import com.lopes.crudcrudretrofit.domain.repository.ComicsRepositoryContract
import javax.inject.Inject

class SendComicsUseCase @Inject constructor(
    private val comicRepositoryImpl: ComicsRepositoryContract
) {
    suspend fun execute(comic: PostComicRequest) {
        comicRepositoryImpl.sendComics(comic)
    }

}
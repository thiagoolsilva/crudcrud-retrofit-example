package com.lopes.crudcrudretrofit.domain.interactor

import com.lopes.crudcrudretrofit.domain.repository.ComicsRepositoryContract
import javax.inject.Inject

class DeleteComicByIdUseCase @Inject constructor(
    private val comicRepositoryImpl: ComicsRepositoryContract
){
    suspend fun execute(id: String) = comicRepositoryImpl.deleteComicsById(id)
}
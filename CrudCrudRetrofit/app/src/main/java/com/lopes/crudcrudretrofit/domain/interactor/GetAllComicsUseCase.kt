package com.lopes.crudcrudretrofit.domain.interactor

import com.lopes.crudcrudretrofit.domain.repository.ComicsRepositoryContract
import javax.inject.Inject

class GetAllComicsUseCase @Inject constructor(
    private val comicRepositoryImpl: ComicsRepositoryContract
){
    suspend fun execute() = comicRepositoryImpl.getAllComics()
}
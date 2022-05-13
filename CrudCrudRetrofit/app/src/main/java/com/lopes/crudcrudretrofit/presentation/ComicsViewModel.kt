package com.lopes.crudcrudretrofit.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lopes.crudcrudretrofit.TAG
import com.lopes.crudcrudretrofit.data.api.dto.GetComicsItemResponse
import com.lopes.crudcrudretrofit.data.api.dto.PostComicRequest
import com.lopes.crudcrudretrofit.domain.interactor.DeleteComicByIdUseCase
import com.lopes.crudcrudretrofit.domain.interactor.GetAllComicsUseCase
import com.lopes.crudcrudretrofit.domain.interactor.SendComicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.serpro69.kfaker.faker
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val getAllComicsUseCase: GetAllComicsUseCase,
    private val sendComicsUseCase: SendComicsUseCase,
    private val deleteComicByIdUseCase: DeleteComicByIdUseCase
) : ViewModel() {

    private val _comicsMutableLiveData = MutableLiveData<ArrayList<GetComicsItemResponse>>()
    val allComics: LiveData<ArrayList<GetComicsItemResponse>>
        get() = _comicsMutableLiveData

    private val _deleteMutableLiveData = MutableLiveData<Boolean>()
    val deleteMutableLiveData: LiveData<Boolean>
        get() = _deleteMutableLiveData

    fun getAllComics() {
        viewModelScope.launch {
            try{
                val result = getAllComicsUseCase.execute()
                _comicsMutableLiveData.value = result
            } catch(error: Exception) {
                Log.e(TAG, error.toString(), error)
            }
        }
    }

    fun sendComics() {
        viewModelScope.launch {
            try{
                val faker = faker {}
                val comics = PostComicRequest(faker.name.name())

                sendComicsUseCase.execute(comics)
                Log.d(TAG, "finished to send the user $comics")
            } catch(error: Error) {
                Log.e(TAG, error.toString(), error)
            }
        }
    }

    fun deleteComicsById() {
        viewModelScope.launch {
            try{
                val result = getAllComicsUseCase.execute()
                if(result.isNotEmpty()) {
                    val item = result.first()
                    deleteComicByIdUseCase.execute(item.id)

                    _deleteMutableLiveData.value = true
                } else  {
                    _deleteMutableLiveData.value = false
                }
            } catch(error: Error) {
                Log.e(TAG, error.toString(), error)
            }
        }
    }
}
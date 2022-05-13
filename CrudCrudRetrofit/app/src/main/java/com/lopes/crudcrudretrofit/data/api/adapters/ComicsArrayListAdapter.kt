package com.lopes.crudcrudretrofit.data.api.adapters

import com.lopes.crudcrudretrofit.data.api.dto.GetComicsItemResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class ComicsArrayListAdapter {
    @ToJson
    fun arrayListToJson(list: ArrayList<GetComicsItemResponse>): List<GetComicsItemResponse> = list

    @FromJson
    fun arrayListFromJson(list: List<GetComicsItemResponse>): ArrayList<GetComicsItemResponse> = ArrayList(list)
}


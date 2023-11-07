package com.example.recycleview.data

import com.example.recycleview.models.AllghostRadioList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("youtubelist")
    suspend fun getListYoutube() : Response<AllghostRadioList>
}
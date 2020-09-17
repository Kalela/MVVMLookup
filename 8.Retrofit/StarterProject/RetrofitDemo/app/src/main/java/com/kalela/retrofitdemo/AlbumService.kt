package com.kalela.retrofitdemo

import com.kalela.retrofitdemo.model.Albums
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("https://jsonplaceholder.typicode.com/albums")
    suspend fun getAlbums(): Response<Albums>
}
package com.kalela.retrofitdemo

import com.kalela.retrofitdemo.model.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>

    @GET("/albums")
    suspend fun getUsersAlbums(@Query("userId") userId: Int): Response<Albums>
}
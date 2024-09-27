package com.luckgg.network

import com.luckgg.network.remote.dto.CatDTO
import com.luckgg.network.remote.dto.CatImageDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatAPI {
    @GET("/v1/breeds")
    suspend fun getCats(): List<CatDTO>

    @GET("/v1/breeds/search")
    suspend fun searchCats(
        @Query("q") query: String,
    ): List<CatDTO>

    @GET("/v1/images/{imageId}")
    suspend fun getCatImage(
        @Path("imageId") imageId: String,
    ): CatImageDTO
}

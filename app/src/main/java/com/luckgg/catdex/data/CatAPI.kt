package com.luckgg.catdex.data

import com.luckgg.catdex.data.remote.dto.CatDTO
import com.luckgg.catdex.data.remote.dto.CatImageDTO
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

package com.luckgg.catdex.data

import com.luckgg.catdex.data.remote.response.CatBreedListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CatAPI {
    @GET("/breeds")
    suspend fun getCats(): CatBreedListResponse

    @GET("/breeds/search")
    suspend fun searchCats(
        @Query("q") query: String,
    ): CatBreedListResponse
}

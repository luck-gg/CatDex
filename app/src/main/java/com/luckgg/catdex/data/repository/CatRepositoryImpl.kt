package com.luckgg.catdex.data.repository

import com.luckgg.catdex.common.Constants.ERROR_UNEXPECTED
import com.luckgg.catdex.common.Resource
import com.luckgg.catdex.data.mapper.CatMapper
import com.luckgg.catdex.data.remote.RemoteSource
import com.luckgg.catdex.domain.model.Cat
import com.luckgg.catdex.domain.model.CatImage
import com.luckgg.catdex.domain.repository.CatRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CatRepositoryImpl
    @Inject
    constructor(
        private val remoteSource: RemoteSource,
    ) : CatRepository {
        private val mapper = CatMapper()

        override suspend fun getCats(): Resource<List<Cat>> =
            try {
                Resource.Success(mapper.mapToDomainCats(remoteSource.getCats()))
            } catch (e: HttpException) {
                Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED)
            } catch (e: IOException) {
                Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED)
            }

        override suspend fun searchCats(query: String): Resource<List<Cat>> {
            TODO("Not yet implemented")
        }

        override suspend fun getCatImage(id: String): Resource<CatImage> =
            try {
                Resource.Success(mapper.mapToDomainCatImage(remoteSource.getCatImage(id)))
            } catch (e: HttpException) {
                Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED)
            } catch (e: IOException) {
                Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED)
            }
    }

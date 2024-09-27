package com.luckgg.network.repository

import com.luckgg.catdex.domain.repository.CatRepository
import com.luckgg.common.Constants.ERROR_UNEXPECTED
import com.luckgg.common.Resource
import com.luckgg.domain.model.Cat
import com.luckgg.domain.model.CatImage
import com.luckgg.network.mapper.CatMapper
import com.luckgg.network.remote.RemoteSource
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
                Resource.Success(
                    mapper.mapToDomainCatImage(
                        remoteSource.getCatImage(id),
                    ),
                )
            } catch (e: HttpException) {
                Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED)
            } catch (e: IOException) {
                Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED)
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED)
            }
    }

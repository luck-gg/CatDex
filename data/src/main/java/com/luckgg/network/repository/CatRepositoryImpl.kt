package com.luckgg.network.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.luckgg.common.Constants.ERROR_UNEXPECTED
import com.luckgg.common.Resource
import com.luckgg.domain.model.Cat
import com.luckgg.domain.model.CatImage
import com.luckgg.domain.repository.CatRepository
import com.luckgg.network.mapper.CatMapper
import com.luckgg.network.paging.CatPagingSource
import com.luckgg.network.remote.RemoteSource
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CatRepositoryImpl
    @Inject
    constructor(
        private val remoteSource: RemoteSource,
    ) : CatRepository {
        private val mapper = CatMapper()

        override fun fetchCats(): Flow<PagingData<Cat>> =
            Pager(
                PagingConfig(pageSize = 10),
            ) {
                CatPagingSource(remoteSource, mapper)
            }.flow

        override suspend fun searchCats(query: String): Resource<List<Cat>> {
            TODO("Not yet implemented")
        }

        override suspend fun fetchCatImage(id: String): Resource<CatImage> =
            try {
                Resource.Success(
                    mapper.mapToDomainCatImage(
                        remoteSource.fetchCatImage(id),
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

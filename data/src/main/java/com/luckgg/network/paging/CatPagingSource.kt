package com.luckgg.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.luckgg.domain.model.Cat
import com.luckgg.network.mapper.CatMapper
import com.luckgg.network.remote.RemoteSource

class CatPagingSource(
    private val remoteSource: RemoteSource,
    private val mapper: CatMapper,
) : PagingSource<Int, Cat>() {
    override fun getRefreshKey(state: PagingState<Int, Cat>): Int =
        ((state.anchorPosition ?: INITIAL_PAGE_NUMBER) - state.config.initialLoadSize / 2)
            .coerceAtLeast(INITIAL_PAGE_NUMBER)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> =
        try {
            val nextPage = params.key ?: INITIAL_PAGE_NUMBER
            val response =
                mapper
                    .mapToDomainCats(
                        remoteSource.fetchCats(limit = params.loadSize, page = nextPage),
                    ).map { cat ->
                        val imageUrl = remoteSource.fetchCatImage(cat.imageId).url
                        cat.copy(imageUrl = imageUrl)
                    }
            LoadResult.Page(
                data = response,
                prevKey = if (nextPage == INITIAL_PAGE_NUMBER) null else nextPage - 1,
                nextKey = nextPage + 1,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    companion object {
        private const val INITIAL_PAGE_NUMBER = 0
    }
}

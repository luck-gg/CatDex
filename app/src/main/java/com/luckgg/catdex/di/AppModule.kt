package com.luckgg.catdex.di

import com.luckgg.catdex.domain.repository.CatRepository
import com.luckgg.catdex.domain.usecase.CatListUseCase
import com.luckgg.common.Constants.API_KEY_DATA
import com.luckgg.common.Constants.API_KEY_TITLE
import com.luckgg.common.Constants.BASE_URL
import com.luckgg.common.Constants.CONTENT_TYPE_DATA
import com.luckgg.common.Constants.CONTENT_TYPE_TITLE
import com.luckgg.network.CatAPI
import com.luckgg.network.remote.RemoteSource
import com.luckgg.network.remote.source.RemoteSourceImpl
import com.luckgg.network.repository.CatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val httpClient: OkHttpClient =
        OkHttpClient
            .Builder()
            .addNetworkInterceptor { chain ->
                val request =
                    chain
                        .request()
                        .newBuilder()
                        .addHeader(API_KEY_TITLE, API_KEY_DATA)
                        .addHeader(CONTENT_TYPE_TITLE, CONTENT_TYPE_DATA)
                        .build()
                chain.proceed(request)
            }.build()

    @Provides
    @Singleton
    fun provideCatAPI(): CatAPI =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatAPI::class.java)

    @Provides
    @Singleton
    fun provideRemoteSource(api: CatAPI): RemoteSource = RemoteSourceImpl(apiService = api)

    @Provides
    @Singleton
    fun provideCatRepository(remoteSource: RemoteSource): CatRepository = CatRepositoryImpl(remoteSource = remoteSource)

    @Provides
    @Singleton
    fun provideCatListUseCase(catRepository: CatRepository): CatListUseCase = CatListUseCase(catRepository = catRepository)
}

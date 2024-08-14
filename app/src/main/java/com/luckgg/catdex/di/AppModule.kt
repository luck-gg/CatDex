package com.luckgg.catdex.di

import com.luckgg.catdex.common.Constants.API_KEY_DATA
import com.luckgg.catdex.common.Constants.API_KEY_TITLE
import com.luckgg.catdex.common.Constants.CONTENT_TYPE_DATA
import com.luckgg.catdex.common.Constants.CONTENT_TYPE_TITLE
import com.luckgg.catdex.data.CatAPI
import com.luckgg.catdex.data.repository.CatRepositoryImpl
import com.luckgg.catdex.domain.repository.CatRepository
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
    val httpClient =
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
            .baseUrl("https://api.thecatapi.com/v1")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatAPI::class.java)

    @Provides
    @Singleton
    fun provideCatRepository(): CatRepository = CatRepositoryImpl()
}

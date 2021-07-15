package com.droidknights.app2021.data.di

import com.droidknights.app2021.data.ConferenceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    @Singleton
    fun provideConferenceApi(
        retrofit: Retrofit
    ): ConferenceApi {
        return retrofit.create(ConferenceApi::class.java)
    }
}
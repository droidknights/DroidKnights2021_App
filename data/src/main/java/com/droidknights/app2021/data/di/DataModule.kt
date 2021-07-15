package com.droidknights.app2021.data.di

import com.droidknights.app2021.data.ConferenceRepository
import com.droidknights.app2021.data.api.ConferenceApi
import com.droidknights.app2021.data.repository.ConferenceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule.ApiModule::class])
abstract class DataModule {
    @Binds
    abstract fun bindsConferenceRepository(
        repository: ConferenceRepositoryImpl
    ): ConferenceRepository

    @InstallIn(SingletonComponent::class)
    @Module
    internal object ApiModule {
        @Provides
        @Singleton
        fun provideConferenceApi(
            retrofit: Retrofit
        ): ConferenceApi {
            return retrofit.create(ConferenceApi::class.java)
        }
    }
}
package com.droidknights.app2021.detail.di

import com.droidknights.app2021.detail.navigation.DetailNavigatorImpl
import com.droidknights.app2021.navigator.DetailNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class NavigatorModule {
    @Binds
    abstract fun provideWeeklyNavigator(
        navigator: DetailNavigatorImpl
    ): DetailNavigator
}
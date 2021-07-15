package com.droidknights.app2021.di

import com.droidknights.app2021.provider.CacheAssetLoader
import com.droidknights.app2021.shared.di.AssetProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class AssetModule {
    @Binds
    abstract fun bindsAssetProvider(
        assetLoader: CacheAssetLoader
    ): AssetProvider
}
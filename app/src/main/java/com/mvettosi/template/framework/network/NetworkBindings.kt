package com.mvettosi.template.framework.network

import com.mvettosi.template.core.data.RemoteNameDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkBindings {
  @Binds
  abstract fun bindRemoteNameDataSource(
      fakeNetworkNameDataSource: FakeNetworkNameDataSource
  ): RemoteNameDataSource
}

package com.mvettosi.template.core.data

import javax.inject.Inject

class NameRepository
@Inject
constructor(
    private val localNameDataSource: LocalNameDataSource,
    private val remoteNameDataSource: RemoteNameDataSource
) {
  suspend fun getName() =
      localNameDataSource.getPersistedName()
          ?: remoteNameDataSource.getNameFromNetwork().also { localNameDataSource.storeName(it) }
}

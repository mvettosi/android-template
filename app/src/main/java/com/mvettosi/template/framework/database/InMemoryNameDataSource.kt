package com.mvettosi.template.framework.database

import com.mvettosi.template.core.data.LocalNameDataSource
import javax.inject.Inject

class InMemoryNameDataSource @Inject constructor() : LocalNameDataSource {
  var storedName: String? = null

  override suspend fun getPersistedName() = storedName

  override suspend fun storeName(name: String) {
    storedName = name
  }
}

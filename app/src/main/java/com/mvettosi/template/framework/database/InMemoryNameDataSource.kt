package com.mvettosi.template.framework.database

import com.mvettosi.template.core.data.LocalNameDataSource
import com.mvettosi.template.core.domain.Name
import javax.inject.Inject

class InMemoryNameDataSource @Inject constructor() : LocalNameDataSource {
  var storedName: Name? = null

  override suspend fun getPersistedName() = storedName

  override suspend fun storeName(name: Name) {
    storedName = name
  }
}

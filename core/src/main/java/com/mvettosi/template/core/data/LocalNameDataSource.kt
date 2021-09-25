package com.mvettosi.template.core.data

import com.mvettosi.template.core.domain.Name

interface LocalNameDataSource {
  suspend fun getPersistedName(): Name?
  suspend fun storeName(name: Name)
}

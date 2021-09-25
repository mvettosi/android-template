package com.mvettosi.template.core.data

interface LocalNameDataSource {
  suspend fun getPersistedName(): String?
  suspend fun storeName(name: String)
}

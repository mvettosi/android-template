package com.mvettosi.template.core.data

interface RemoteNameDataSource {
  suspend fun getNameFromNetwork(): String
}

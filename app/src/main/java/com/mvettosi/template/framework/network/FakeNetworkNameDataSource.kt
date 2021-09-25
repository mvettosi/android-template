package com.mvettosi.template.framework.network

import com.mvettosi.template.core.data.RemoteNameDataSource
import javax.inject.Inject
import kotlinx.coroutines.delay

class FakeNetworkNameDataSource @Inject constructor() : RemoteNameDataSource {
  override suspend fun getNameFromNetwork(): String {
    delay(2000)
    return "Template"
  }
}

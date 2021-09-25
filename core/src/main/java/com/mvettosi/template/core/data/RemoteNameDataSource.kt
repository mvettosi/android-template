package com.mvettosi.template.core.data

import com.mvettosi.template.core.domain.Name

interface RemoteNameDataSource {
  suspend fun getNameFromNetwork(): Name
}

package com.mvettosi.template.core.usecases

import com.mvettosi.template.core.data.NameRepository
import javax.inject.Inject

class GetNameUseCase @Inject constructor(private val nameRepository: NameRepository) {
  suspend operator fun invoke() = nameRepository.getName()
}

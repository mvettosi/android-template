package com.mvettosi.template.core.integration

import com.mvettosi.template.core.data.LocalNameDataSource
import com.mvettosi.template.core.data.NameRepository
import com.mvettosi.template.core.data.RemoteNameDataSource
import com.mvettosi.template.core.domain.Name
import com.mvettosi.template.core.usecases.GetNameUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import java.lang.RuntimeException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetNameIntegrationTest {
  @RelaxedMockK lateinit var localNameDataSource: LocalNameDataSource
  @RelaxedMockK lateinit var remoteNameDataSource: RemoteNameDataSource

  lateinit var getNameUseCase: GetNameUseCase

  @Before
  fun setUp() {
    MockKAnnotations.init(this)
    getNameUseCase =
        GetNameUseCase(
            nameRepository =
                NameRepository(
                    localNameDataSource = localNameDataSource,
                    remoteNameDataSource = remoteNameDataSource))
  }

  @Test
  @ExperimentalCoroutinesApi
  fun `local storage returns value`() = runBlockingTest {
    // Arrange
    val expected = Name(first = "first", last = "last")
    coEvery { localNameDataSource.getPersistedName() } returns expected
    coEvery { remoteNameDataSource.getNameFromNetwork() } throws RuntimeException()

    // Act
    val actual = getNameUseCase()

    // Assert
    Assert.assertEquals(expected, actual)
  }

  @Test
  @ExperimentalCoroutinesApi
  fun `local storage returns null`() = runBlockingTest {
    // Arrange
    val expected = Name(first = "first", last = "last")
    coEvery { localNameDataSource.getPersistedName() } returns null
    coEvery { remoteNameDataSource.getNameFromNetwork() } returns expected

    // Act
    val actual = getNameUseCase()

    // Assert
    Assert.assertEquals(expected, actual)
  }
}

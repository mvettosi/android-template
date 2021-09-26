package com.mvettosi.template.core.data

import com.mvettosi.template.core.domain.Name
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import java.lang.RuntimeException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NameRepositoryTest {
  @RelaxedMockK lateinit var localNameDataSource: LocalNameDataSource
  @RelaxedMockK lateinit var remoteNameDataSource: RemoteNameDataSource

  lateinit var underTest: NameRepository

  @Before
  fun setUp() {
    MockKAnnotations.init(this)
    underTest =
        NameRepository(
            localNameDataSource = localNameDataSource, remoteNameDataSource = remoteNameDataSource)
  }

  @Test
  @ExperimentalCoroutinesApi
  fun `local storage returns value`() = runBlockingTest {
    // Arrange
    val expected = Name(first = "first", last = "last")
    coEvery { localNameDataSource.getPersistedName() } returns expected
    coEvery { remoteNameDataSource.getNameFromNetwork() } throws RuntimeException()

    // Act
    val actual = underTest.getName()

    // Assert
    assertEquals(expected, actual)
    coVerify(exactly = 0) { remoteNameDataSource.getNameFromNetwork() }
    coVerify(exactly = 0) { localNameDataSource.storeName(any()) }
  }

  @Test
  @ExperimentalCoroutinesApi
  fun `local storage returns null`() = runBlockingTest {
    // Arrange
    val expected = Name(first = "first", last = "last")
    coEvery { localNameDataSource.getPersistedName() } returns null
    coEvery { remoteNameDataSource.getNameFromNetwork() } returns expected

    // Act
    val actual = underTest.getName()

    // Assert
    assertEquals(expected, actual)
    coVerify { remoteNameDataSource.getNameFromNetwork() }
    coVerify { localNameDataSource.storeName(expected) }
  }
}

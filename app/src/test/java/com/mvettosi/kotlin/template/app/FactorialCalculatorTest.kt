package com.mvettosi.kotlin.template.app

import com.mvettosi.kotlin.template.app.FactorialCalculator.computeFactorial
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FactorialCalculatorTest {

    @Test
    fun computeFactorial_withNegative_raiseException() {
        assertThrows(Exception::class.java) {
            computeFactorial(-1)
        }
    }

    @Test
    fun computeFactorial_forZero() {
        assertEquals(1, computeFactorial(0))
    }

    @Test
    fun computeFactorial_forFive() {
        assertEquals(120, computeFactorial(5))
    }
}
